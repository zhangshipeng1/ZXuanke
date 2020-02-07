package com.zsp.student.controler;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zsp.student.entity.Frindpovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.service.FrindService;
import com.zsp.student.serviceimpl.FrindServiceimpl;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/18:40/2019/11/18
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping(value = "/Friend")
public class FrindsController {
    @Autowired
    FrindService frindService;
    @RequestMapping(value = "/frind.action" ,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectmyFrinds(HttpSession session){
        TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");

      System.out.println(frindService.selectFrind(userloginpovo.getSlUsername()));
       List<Frindpovo> frindpovos= frindService.selectFrind(userloginpovo.getSlUsername());
        PageInfo info=new PageInfo (frindpovos);
        System.out.println(frindpovos);
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",info.getTotal());
        obj.put("data",frindpovos);
        return obj.toJSONString();

    }



}
