package com.zsp.teacher.controler;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsp.student.entity.CourseMessagePovo;
import com.zsp.student.entity.Coursespovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.teacher.entity.Bingpovo;
import com.zsp.teacher.entity.Courseoptionpovo;
import com.zsp.teacher.entity.XuankethMesspovo;
import com.zsp.teacher.service.XuankeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2020/13:42/2020/1/31
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping("/xuankeMessage")
public class XuankeMessageController {
    @Autowired
    private XuankeMessageService xuankeMessageService;
    @ResponseBody
    @RequestMapping("/gettudata.action")
    public List<Bingpovo>  gettudata(){
        List<Bingpovo> bingpovos=xuankeMessageService.getTuData();
return bingpovos;
    }
    @ResponseBody
    @RequestMapping(value = "/getthxuankeData.action", produces = "application/json; charset=utf-8")
    public String getthxuankeData(HttpServletResponse response, Integer page , Integer limit , String key,String cXueyuan,String cZhuanye,String cClass, HttpSession session){
        List<XuankethMesspovo> xuankethMesspovos=null;

        TbUserloginpovo tbUserloginpovo= (TbUserloginpovo) session.getAttribute ("user");
        String username=tbUserloginpovo.getSlUsername ();
        System.out.println(cXueyuan+""+cZhuanye+""+cClass);
        response.setContentType ("application/json;charset=UTF-8");
        PageHelper.startPage (page,limit);

        if (key!=null||cXueyuan!=null||cZhuanye!=null){

            xuankethMesspovos=xuankeMessageService.thgetCourseBYsomething(cClass,key,cXueyuan,cZhuanye,username);


        }else
        {
            xuankethMesspovos=  xuankeMessageService.thgetCourse (username);

        }
        System.out.println("sasawq"+xuankethMesspovos);

        PageInfo info=new PageInfo (xuankethMesspovos);
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",info.getTotal());
        obj.put("data",xuankethMesspovos);
        return obj.toJSONString();
    }
    //获取课程下拉列表数据
    @ResponseBody
    @RequestMapping(value = "/getcourse.action", produces = "application/json; charset=utf-8")
    public List<Courseoptionpovo> getcourse(String sNumber){
        List<Courseoptionpovo> courseoptionpovos= xuankeMessageService.getCourses(sNumber);
        System.out.println(courseoptionpovos);
        return courseoptionpovos;
    }
}
