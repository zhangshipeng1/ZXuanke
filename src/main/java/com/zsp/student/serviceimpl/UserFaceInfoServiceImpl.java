package com.zsp.student.serviceimpl;

import com.zsp.student.entity.UserFaceInfo;
import com.zsp.student.mapping.UserFaceInfoMapper;
import com.zsp.student.service.UserFaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFaceInfoServiceImpl implements UserFaceInfoService {


    @Autowired
    private UserFaceInfoMapper userFaceInfoMapper;

    @Override
    public void insertSelective(UserFaceInfo userFaceInfo) {

       UserFaceInfo userFaceInfo1= userFaceInfoMapper.selectUserFaceInfo( userFaceInfo.getName());
        System.out.println("fffffds"+userFaceInfo1);

           userFaceInfoMapper.insertUserFaceInfo(userFaceInfo);


    }
}
