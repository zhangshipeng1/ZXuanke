package com.zsp.student.controler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.zsp.student.entity.*;

import com.zsp.student.service.FaceService;
import com.zsp.student.service.UserFaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/20:28/2019/12/16
 * @logNmae：zsp
 * @DO:
 */
@Controller
public class FaceController {
    @Autowired
    private FaceService faceService;
    @Autowired
    UserFaceInfoService userFaceInfoService;
    @RequestMapping(value = "/faceAdd.action", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> faceAdd(@RequestParam("file") String file, @RequestParam("groupId") Integer groupId,@RequestParam("email") String email,@RequestParam("phone") String phone ,@RequestParam("name") String name) {
        Short x=0;
        Short y=1;
        System.out.println(phone+email);
        try {
            if (file == null) {
                return Results.newFailedResult("file is null");
            }
            if (groupId == null) {
                return Results.newFailedResult("groupId is null");
            }
            if (name == null) {
                return Results.newFailedResult("name is null");
            }

//
            byte[] decode = Base64.decode(base64Process(file));
            ImageInfo imageInfo = ImageFactory.getRGBData(decode);
            List<ProcessInfo> processInfoList = faceService.process(imageInfo);
            //人脸特征获取
            byte[] bytes = faceService.extractFaceFeature(imageInfo);
            if (bytes == null) {
                return Results.newFailedResult(ErrorCodeEnum.NO_FACE_DETECTED);
            }
            System.out.println("lllllllllllllllll");
            UserFaceInfo userFaceInfo = new UserFaceInfo();
            userFaceInfo.setName(name);
            userFaceInfo.setGroupId(groupId);
            userFaceInfo.setFaceFeature(bytes);
            userFaceInfo.setFaceId(RandomUtil.randomString(10));
            System.out.println("lllllllllllllllll");
            userFaceInfo.setEmail(email);
            System.out.println("lllllllllllllllll");
            userFaceInfo.setPhoneNumber(phone);
            System.out.println(userFaceInfo);
            userFaceInfoService.insertSelective(userFaceInfo);

            return Results.newSuccessResult("");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return Results.newFailedResult(ErrorCodeEnum.UNKNOWN);
    }
    @RequestMapping("/faceSearch.action")
    @ResponseBody

    public Result<FaceSearchResDto> FaceSerch(String file, Integer groupId)  throws Exception{

        if (groupId == null) {
            return Results.newFailedResult("groupId is null");
        }
        byte[] decode = Base64.decode(base64Process(file));
        BufferedImage bufImage = ImageIO.read(new ByteArrayInputStream(decode));
        ImageInfo imageInfo = ImageFactory.bufferedImage2ImageInfo(bufImage);
        byte[] bytes = faceService.extractFaceFeature(imageInfo);
        if (bytes == null) {
            return Results.newFailedResult(ErrorCodeEnum.NO_FACE_DETECTED);
        }
        List<FaceUserInfo> userFaceInfoList = faceService.compareFaceFeature(bytes, groupId);
        if (CollectionUtil.isNotEmpty(userFaceInfoList)) {
            FaceUserInfo faceUserInfo = userFaceInfoList.get(0);
            FaceSearchResDto faceSearchResDto = new FaceSearchResDto();
            BeanUtil.copyProperties(faceUserInfo, faceSearchResDto);
            List<ProcessInfo> processInfoList = faceService.process(imageInfo);
            if (CollectionUtil.isNotEmpty(processInfoList)) {
                //人脸检测
                List<FaceInfo> faceInfoList = faceService.detectFaces(imageInfo);
                int left = faceInfoList.get(0).getRect().getLeft();
                int top = faceInfoList.get(0).getRect().getTop();
                int width = faceInfoList.get(0).getRect().getRight() - left;
                int height = faceInfoList.get(0).getRect().getBottom() - top;

                Graphics2D graphics2D = bufImage.createGraphics();
                graphics2D.setColor(Color.RED);//红色
                BasicStroke stroke = new BasicStroke(5f);
                graphics2D.setStroke(stroke);
                graphics2D.drawRect(left, top, width, height);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufImage, "jpg", outputStream);
                byte[] bytes1 = outputStream.toByteArray();
                faceSearchResDto.setImage("data:image/jpeg;base64," + Base64Utils.encodeToString(bytes1));
                faceSearchResDto.setAge(processInfoList.get(0).getAge());
                faceSearchResDto.setGender(processInfoList.get(0).getGender().equals(1) ? "女" : "男");

            }
            return Results.newSuccessResult(faceSearchResDto);
    }
        return Results.newFailedResult(ErrorCodeEnum.FACE_DOES_NOT_MATCH);
    }
    private String base64Process(String base64Str) {
        if (!StringUtils.isEmpty(base64Str)) {
            String photoBase64 = base64Str.substring(0, 30).toLowerCase();
            int indexOf = photoBase64.indexOf("base64,");
            if (indexOf > 0) {
                base64Str = base64Str.substring(indexOf + 7);
            }

            return base64Str;
        } else {
            return "";
        }
    }
}
