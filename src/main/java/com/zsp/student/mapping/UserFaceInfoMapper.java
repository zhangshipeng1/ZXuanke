package com.zsp.student.mapping;

import com.zsp.student.entity.FaceUserInfo;
import com.zsp.student.entity.UserFaceInfo;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/21:51/2019/12/16
 * @logNmae：zsp
 * @DO:
 */
public interface UserFaceInfoMapper {
    List<UserFaceInfo> findUserFaceInfoList();

    void insertUserFaceInfo(UserFaceInfo userFaceInfo);
    public List<FaceUserInfo> getUserFaceInfoByGroupId(Integer groupId);

    UserFaceInfo selectUserFaceInfo(String name);
}
