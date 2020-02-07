package com.zsp.student.controler;

import com.zsp.student.entity.RegistPovo;
import com.zsp.student.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author：张世朋
 * @Date：Create in2019/18:16/2019/12/25
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping("/regist")
public class RegistController {
    @Autowired
    private RegistService registService;
    @RequestMapping(value = "/selectId.action")
    @ResponseBody
    public boolean isHaveID(String rNumber){

        Boolean is=registService.isHasById(rNumber);
        return is;
    }

    @RequestMapping(value = "/delregistuserface.action")
    @ResponseBody
    public boolean delregistuserface(@RequestParam("faceid") String data){
        System.out.println("data="+data);
        Boolean is=registService.delregistuserface(data);
        return is;
    }
    @RequestMapping(value = "/getisHasUserName.action")
    @ResponseBody
    public boolean getisHasUserName(String username){

        Boolean is=registService.isHasUserName(username);
        return is;
    }

    @RequestMapping(value = "/registuser.action")
    @ResponseBody
    public boolean registuser(RegistPovo registPovo){
        Boolean bool=registService.regist(registPovo);
        System.out.println("zhuce*************"+bool);
        return bool;
    }
    @RequestMapping(value = "/selectCode.action")
    @ResponseBody
    public boolean iscode(String code, HttpSession session){
       String codeget= (String) session.getAttribute("codedata");
       if(codeget.equalsIgnoreCase(code)){
        return true;
       }
     return  false;
    }

}
