package com.zsp.student.controler;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import com.zsp.student.entity.CourseMessagePovo;
import com.zsp.student.entity.Coursespovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.entity.YiXuan;
import com.zsp.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * @PackageName:com.zsp.student.controler
 * @ClassName:CourseControler
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/12 19:42
 */
@Controller
@RequestMapping("/course")
public class CourseControler {
    @Autowired
    private CourseService courseService;
    //查询成绩与搜索成绩

    /**
     *查询课程
     * @param response
     * @param page
     * @param limit
     * @param key
     * @param slXueyuan
     * @param slZhuanye
     * @return
     */
    @RequestMapping(value = "/getallCourse.action", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectcourse(HttpServletResponse response, Integer page ,Integer limit ,String key,String slXueyuan,String slZhuanye){
        List<Coursespovo> coursespovos=null;

        response.setContentType ("application/json;charset=UTF-8");
        PageHelper.startPage (page,limit);

        if (key!=null||slXueyuan!=null||slZhuanye!=null){
            System.out.println("key"+key);
            coursespovos=courseService.getCourseBYsomething(key,slXueyuan,slZhuanye);


        }else
            {
            coursespovos=  courseService.getCourse ();

        }
        for (Coursespovo coursespovo: coursespovos
             ) {
            System.out.println("ssssssssssssss"+coursespovo.toString());
        }


        PageInfo info=new PageInfo (coursespovos);
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",info.getPages ());
        obj.put("data",coursespovos);
        return obj.toJSONString();


    }

    /**
     *单选
     * @param coursespovo
     * @param response
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/xuanke.action",produces = "application/json; charset=utf-8")
    public Boolean insertCourse(@RequestBody Coursespovo coursespovo, HttpServletResponse response, HttpSession session){
        response.setContentType ("application/json;charset=UTF-8");
        boolean flag=false;
        if(coursespovo!=null){
            TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");
            flag=courseService.insertXuankes(coursespovo,userloginpovo);
        }

      return flag;
    }

    /**
     * 批量选课
     * @param coursespovos
     * @param response
     * @param session
     * @return string
     */
    @ResponseBody
    @RequestMapping(value = "/duoxuan.action",produces = "application/html; charset=utf-8")
    public  String insertCourses(@RequestBody  List<Coursespovo> coursespovos,HttpServletResponse response,HttpSession session){
        response.setContentType ("application/json;charset=UTF-8");
        Iterator iterator=coursespovos.iterator();
        int i=0;
        int j=0;
        boolean flag=false;
        while (iterator.hasNext()){
            j++;
            Coursespovo coursespovo=(Coursespovo) iterator.next();
            if(coursespovo!=null){
                TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");
                flag=courseService.insertXuankes(coursespovo,userloginpovo);
                if(flag){
                  i++;
                }
            }
        }
        if(j>i){
            return "成功选课"+i+"条"+"失败"+(j-i)+"条";
        }if (j==i){
            return "选课完毕";
        }
        return "选课失败";
    }
    @ResponseBody
    @RequestMapping(value = "/selectCourseMessage.action",produces = "application/html; charset=utf-8")
    public String selectCourseMessage(HttpServletResponse response, Integer page ,Integer limit ,String key,String cXueyuan,String cZhuanye){
        List<CourseMessagePovo> courseMessagePovos=null;
        if (key!=null||cXueyuan!=null||cZhuanye!=null){
            System.out.println("key"+key);
            courseMessagePovos=courseService.getCourseMessageBYsomething(key,cXueyuan,cZhuanye);


        }else
        {
            courseMessagePovos=  courseService.getCourseMessage ();

        }
        for (CourseMessagePovo courseMessagePovo: courseMessagePovos
        ) {
            System.out.println("ssssssssssssss"+courseMessagePovo);
        }


        PageInfo info=new PageInfo (courseMessagePovos);
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",info.getPages ());
        obj.put("data",courseMessagePovos);
        return obj.toJSONString();

    }
    @ResponseBody
    @RequestMapping(value = "/selectYiXuan.action", produces = "application/json; charset=utf-8")
    public List<YiXuan> selectYixuan(HttpSession session){
        TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");
        List <YiXuan> yiXuans=courseService.selectYixuancourse(userloginpovo);
        Iterator<YiXuan> yiXuanIterator=yiXuans.iterator();
        while (yiXuanIterator.hasNext()){
            System.out.println(yiXuanIterator.next());
        }
        return yiXuans;
    }
    @ResponseBody
    @RequestMapping(value = "/delectYiXuan.action",produces = "application/json; charset=utf-8")
    public Boolean  delectYiXuan(String data){

        Boolean isdel=courseService.deleteYiXuan(data);
        return isdel;
    }
}
