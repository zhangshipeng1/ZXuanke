package com.zsp.student.service;

import com.zsp.student.entity.TbStudentlogin;
import com.zsp.student.entity.TbStudentloginpovo;
import com.zsp.student.serviceimpl.LoginServiceimpl;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;


public interface LoginService {

    //Studentloging
    public TbStudentlogin StudentLogin(String slUsername);
}
