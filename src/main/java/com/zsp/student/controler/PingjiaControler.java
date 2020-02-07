package com.zsp.student.controler;

import com.zsp.student.entity.PingjiaPovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.service.PingjiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author：张世朋
 * @Date：Create in2019/9:20/2019/12/11
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping("/pingjia")
public class PingjiaControler  {
    @Autowired
    private PingjiaService pingjiaService;
    @RequestMapping(value = "/InPingjia.action",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean InPingjia(PingjiaPovo pingjiaPovo, HttpSession session){
        TbUserloginpovo tbUserloginpovo= (TbUserloginpovo) session.getAttribute ("user");
           String username =tbUserloginpovo.getSlUsername();
           pingjiaPovo.setsUsername(username);
           Boolean isPingjia=pingjiaService.InPingJia(pingjiaPovo);
           return isPingjia;
        }
}
