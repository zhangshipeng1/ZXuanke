package com.zsp.student.controler;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsp.student.entity.Coursespovo;
import com.zsp.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping(value = "/getallCourse.action", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectcourse(HttpServletResponse response, Integer page ,Integer limit ,String key,String slXueyuan,String slZhuanye){
        List<Coursespovo> coursespovos=null;

        response.setContentType ("application/json;charset=UTF-8");
        PageHelper.startPage (page,limit);
        if (key!=null||slXueyuan!=null||slZhuanye!=null){
            coursespovos=courseService.getCourseBYsomething(key,slXueyuan,slZhuanye);

        }else
            {
            coursespovos=  courseService.getCourse ();

        }

        PageInfo info=new PageInfo (coursespovos);
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",info.getPages ());
        obj.put("data",coursespovos);
        return obj.toJSONString();


    }

}
