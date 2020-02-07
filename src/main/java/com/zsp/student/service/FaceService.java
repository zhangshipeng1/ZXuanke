package com.zsp.student.service;

import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import com.zsp.student.entity.FaceUserInfo;
import com.zsp.student.entity.ProcessInfo;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author：张世朋
 * @Date：Create in2019/20:36/2019/12/16
 * @logNmae：zsp
 * @DO:
 */
public interface FaceService {
    byte[] extractFaceFeature(ImageInfo imageInfo);

    List<FaceUserInfo> compareFaceFeature(byte[] bytes, Integer groupId) throws InterruptedException, ExecutionException;

    List<ProcessInfo> process(ImageInfo imageInfo);

    List<FaceInfo> detectFaces(ImageInfo imageInfo);
}
