package com.zsp.student.controler;

import com.zsp.student.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @PackageName:com.zsp.student.controler
 * @ClassName:TestControler
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/24 11:46
 */
@Controller
public class TestControler {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/test.action")
    public void testadd(HttpSession session ,@RequestParam(defaultValue = "1") String slUsername){

        session.setAttribute ("ss","dd");
        System.out.println("1+++++++++++++++"+loginService.StudentLogin (slUsername));
    }
    @RequestMapping("/test2.action")
    public void testget(HttpSession session){
        System.out.println("2+++++++++++++++"+session.getAttribute ("ss"));
    }
}
