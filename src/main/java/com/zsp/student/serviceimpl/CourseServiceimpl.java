package com.zsp.student.serviceimpl;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.zsp.student.entity.*;
import com.zsp.student.mapping.CourseMapping;
import com.zsp.student.service.CourseService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:com.zsp.student.serviceimpl
 * @ClassName:CourseServiceimpl
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/12 19:35
 */
@Service
public class CourseServiceimpl implements CourseService {
    @Autowired
    private CourseMapping cousermaMapping;
    @Override
    public List<Coursespovo> getCourse() {

        return cousermaMapping.selectAllCourse ();
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public List<Coursespovo> getCourseByName(String key) {
        return cousermaMapping.selectCourseByName(key);
    }

    /**
     *
     * @param key
     * @param slXueyuan
     * @param slZhuanye
     * @return
     */
    @Override
    public List<Coursespovo> getCourseBYsomething(String key,String slXueyuan, String slZhuanye) {
        return cousermaMapping.selectCourseBysomeThing(key,slXueyuan,slZhuanye);
    }

    /**
     * 选课业务
     * @param course
     * @param tbUserloginpovo
     * @return
     */
    @Override
    public boolean insertXuankes(Coursespovo course, TbUserloginpovo tbUserloginpovo) {
        System.out.println(course+"courseserviceimpl");
        //查询是否存在该课程
        IshasCcoursepovo ishasCcoursepovo=cousermaMapping.selectCourseByid(String.valueOf(tbUserloginpovo.getSlId()),String.valueOf(course.getcId()),String.valueOf(course.getTime().getTimeId()));
        if (ishasCcoursepovo==null){
           //查询是否少于30人
         TeacherCourse teacherCourse= cousermaMapping.selectRenshu(String.valueOf(course.getTeacherCourse().getTcId()));
         long renshu=teacherCourse.getTcRenshu();
         if(renshu<=30){
             TbXuanke xuanke =new TbXuanke();
             //设置选课状态
             xuanke.setXuanZhuangtai(1);
             //设置学号
             xuanke.setXuanSlid((int)tbUserloginpovo.getSlId());
             xuanke.setXuanCourse((int)course.getcId());
             xuanke.setXuanTid(course.getTbTeacher().gettId());
             boolean isxuanke= cousermaMapping.insertXuancourse(xuanke) ;
             //人数加一
             if(isxuanke==true){
                 System.out.println(renshu);
             boolean  isrenshuadd= cousermaMapping.updateReanshu(String.valueOf(renshu+1),course.getTeacherCourse().getTcId());
                 return  isrenshuadd;
             }

         }else{
             return false;
         }
       }


        return false;
    }

    /**
     * 条件查询课程信息
     * @param key
     * @param cXueyuan
     * @param cZhuanye
     * @return
     */
    @Override
    public List<CourseMessagePovo> getCourseMessageBYsomething(String key, String cXueyuan, String cZhuanye) {
        return cousermaMapping.selectCourseMessBysomeThing(key,cXueyuan,cZhuanye);
    }

    /**
     * 查询所有信息
     * @return
     */
    @Override
    public List<CourseMessagePovo> getCourseMessage() {

        return cousermaMapping.selectAllCourseMess ();
    }

    @Override
    public List<YiXuan> selectYixuancourse(TbUserloginpovo userloginpovo) {
System.out.println("555555555"+String.valueOf(userloginpovo.getSId()));
               List<YiXuan> yi=cousermaMapping.selectYixuanCourseMap(String.valueOf(userloginpovo.getSlId()));
               System.out.println(yi);
        return cousermaMapping.selectYixuanCourseMap(String.valueOf(userloginpovo.getSlId()));
    }

    @Override
    public Boolean deleteYiXuan(String data) {
       Boolean bol= cousermaMapping.deleteYiXuan(data);

        return bol;
    }
}
