package com.zsp.student.serviceimpl;

import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.mapping.TbStudentloginMapping;
import com.zsp.student.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @PackageName:com.zsp.student.serviceimpl
 * @ClassName:LoginService
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/21 11:16
 */
@Service
public class LoginServiceimpl implements LoginService {
    @Resource
    private TbStudentloginMapping tbStudentloginMapping;
    //Student 登录业务false 代表存在用户，true代表不存在；
    @Override
    public TbUserloginpovo userLogin(String username) {

        TbUserloginpovo tbUserloginpovo=tbStudentloginMapping.selectByUsername (username);

        return tbStudentloginMapping.selectByUsername (username);

    }
}
