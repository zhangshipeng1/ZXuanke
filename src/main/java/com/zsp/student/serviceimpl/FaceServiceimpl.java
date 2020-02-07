package com.zsp.student.serviceimpl;

import cn.hutool.core.collection.CollectionUtil;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import com.google.common.collect.Lists;
import com.zsp.student.entity.FaceUserInfo;
import com.zsp.student.entity.ProcessInfo;
import com.zsp.student.mapping.UserFaceInfoMapper;
import com.zsp.student.service.FaceService;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author：张世朋
 * @Date：Create in2019/20:37/2019/12/16
 * @logNmae：zsp
 * @DO:
 */
@Service
public class FaceServiceimpl implements FaceService {
    @Value("${config.arcface-sdk.app-id}")
  private   String appId ;
    @Value("${config.arcface-sdk.sdk-key}")
  private    String sdkKey ;
    @Value("${config.arcface-sdk.sdk-lib-path}")
    public String sdkLibPath;
    private Integer passRate = 80;

    private GenericObjectPool<FaceEngine> faceEngineObjectPool;
    private ExecutorService executorService=Executors.newFixedThreadPool(8);
    @Autowired
    private UserFaceInfoMapper userFaceInfoMapper;
   public  FaceEngine yinQininit(){
       GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

       FaceEngine faceEngine = new FaceEngine(sdkLibPath);
       //激活引擎
       int activeCode = faceEngine.activeOnline(appId, sdkKey);

       if (activeCode != ErrorInfo.MOK.getValue() && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
           System.out.println("引擎激活失败");
       }

       //引擎配置
       EngineConfiguration engineConfiguration = new EngineConfiguration();
       engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
       engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);

       //功能配置
       FunctionConfiguration functionConfiguration = new FunctionConfiguration();
       functionConfiguration.setSupportAge(true);
       functionConfiguration.setSupportFace3dAngle(true);
       functionConfiguration.setSupportFaceDetect(true);
       functionConfiguration.setSupportFaceRecognition(true);
       functionConfiguration.setSupportGender(true);
       functionConfiguration.setSupportLiveness(true);
       functionConfiguration.setSupportIRLiveness(true);
       engineConfiguration.setFunctionConfiguration(functionConfiguration);


       //初始化引擎
       int initCode = faceEngine.init(engineConfiguration);

       if (initCode != ErrorInfo.MOK.getValue()) {
           System.out.println("初始化引擎失败");
       }
       faceEngineObjectPool = new GenericObjectPool(new FaceEngineFactory(sdkLibPath, appId, sdkKey, engineConfiguration), poolConfig);//底层库算法对象池

       return faceEngine;
    }
    @Override
    public byte[] extractFaceFeature(ImageInfo imageInfo) {
        FaceEngine faceEngine = null;
        try {
            //获取引擎对象
            faceEngine = yinQininit();

            //人脸检测得到人脸列表
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();

            //人脸检测
            int i = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);

            if (CollectionUtil.isNotEmpty(faceInfoList)) {
                FaceFeature faceFeature = new FaceFeature();
                //提取人脸特征
                faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature);

                return faceFeature.getFeatureData();
            }
        } catch (Exception e) {
           throw  e;
        } finally {
            if (faceEngine != null) {
                //释放引擎对象
                int unInitCode = faceEngine.unInit();
            }

        }

        return null;
    }
    //識別

    @Override
    public List<FaceUserInfo> compareFaceFeature(byte[] faceFeature, Integer groupId)  throws InterruptedException, ExecutionException {
        List<FaceUserInfo> resultFaceInfoList = Lists.newLinkedList();//识别到的人脸列表

        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature);
        List<FaceUserInfo> faceInfoList = userFaceInfoMapper.getUserFaceInfoByGroupId(groupId); //从数据库中取出人脸库
        List<List<FaceUserInfo>> faceUserInfoPartList = Lists.partition(faceInfoList, 1000);//分成1000一组，多线程处理
        CompletionService<List<FaceUserInfo>> completionService = new ExecutorCompletionService(executorService);
        for (List<FaceUserInfo> part : faceUserInfoPartList) {
            completionService.submit(new CompareFaceTask(part, targetFaceFeature));
        }
        for (int i = 0; i < faceUserInfoPartList.size(); i++) {
            List<FaceUserInfo> faceUserInfoList = completionService.take().get();
            if (CollectionUtil.isNotEmpty(faceInfoList)) {
                resultFaceInfoList.addAll(faceUserInfoList);
            }
        }

        resultFaceInfoList.sort((h1, h2) -> h2.getSimilarValue().compareTo(h1.getSimilarValue()));//从大到小排序

        return resultFaceInfoList;
    }

    @Override
    public List<FaceInfo> detectFaces(ImageInfo imageInfo)  {
        FaceEngine faceEngine = null;
        try {
            //获取引擎对象
            faceEngine =yinQininit();

            //人脸检测得到人脸列表
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();

            //人脸检测
            faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
            return faceInfoList;
        } catch (Exception e) {
            throw  e;
        } finally {
            if (faceEngine != null) {
                //释放引擎对象
                int unInitCode = faceEngine.unInit();

            }
            return null;
        }

    }


    @Override
    public List<ProcessInfo> process(ImageInfo imageInfo) {
        FaceEngine faceEngine = null;
        try {
            //获取引擎对象
            faceEngine =yinQininit();
            //人脸检测得到人脸列表
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            //人脸检测
            faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
            int processResult = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList, FunctionConfiguration.builder().supportAge(true).supportGender(true).build());
            List<ProcessInfo> processInfoList = Lists.newLinkedList();

            List<GenderInfo> genderInfoList = new ArrayList<GenderInfo>();
            //性别提取
            int genderCode = faceEngine.getGender(genderInfoList);
            //年龄提取
            List<AgeInfo> ageInfoList = new ArrayList<AgeInfo>();
            int ageCode = faceEngine.getAge(ageInfoList);
            for (int i = 0; i < genderInfoList.size(); i++) {
                ProcessInfo processInfo = new ProcessInfo();
                processInfo.setGender(genderInfoList.get(i).getGender());
                processInfo.setAge(ageInfoList.get(i).getAge());
                processInfoList.add(processInfo);
            }
            return processInfoList;

        } catch (Exception e) {
          throw e;
        } finally {
            if (faceEngine != null) {
                //释放引擎对象
                int unInitCode = faceEngine.unInit();;
            }
            return null;
        }

    }

    private class CompareFaceTask implements Callable<List<FaceUserInfo>> {

        private List<FaceUserInfo> faceUserInfoList;
        private FaceFeature targetFaceFeature;


        public CompareFaceTask(List<FaceUserInfo> faceUserInfoList, FaceFeature targetFaceFeature) {
            this.faceUserInfoList = faceUserInfoList;
            this.targetFaceFeature = targetFaceFeature;
        }
        private int plusHundred(Float value) {
            BigDecimal target = new BigDecimal(value);
            BigDecimal hundred = new BigDecimal(100f);
            return target.multiply(hundred).intValue();

        }
        @Override
        public List<FaceUserInfo> call() throws Exception {
            FaceEngine faceEngine = null;
            List<FaceUserInfo> resultFaceInfoList = Lists.newLinkedList();//识别到的人脸列表
            try {
                faceEngine =yinQininit();
                for (FaceUserInfo faceUserInfo : faceUserInfoList) {
                    FaceFeature sourceFaceFeature = new FaceFeature();
                    sourceFaceFeature.setFeatureData(faceUserInfo.getFaceFeature());
                    FaceSimilar faceSimilar = new FaceSimilar();
                    faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
                    Integer similarValue = plusHundred(faceSimilar.getScore());//获取相似值
                    if (similarValue > passRate) {//相似值大于配置预期，加入到识别到人脸的列表

                        FaceUserInfo info = new FaceUserInfo();
                        info.setName(faceUserInfo.getName());
                        info.setFaceId(faceUserInfo.getFaceId());
                        info.setSimilarValue(similarValue);
                        resultFaceInfoList.add(info);
                    }
                }
            } catch (Exception e) {
                throw  e;
            } finally {
                if (faceEngine != null) {
                    int unInitCode = faceEngine.unInit();
                }
            }

            return resultFaceInfoList;
        }

    }

}
