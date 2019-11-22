package com.zsp.student.service;

import com.zsp.student.entity.CourseMessagePovo;
import com.zsp.student.entity.Coursespovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.entity.YiXuan;

import java.util.List;

public interface CourseService {
    List<Coursespovo> getCourse();

    List<Coursespovo> getCourseByName(String key);

    List<Coursespovo> getCourseBYsomething(String key,String slXueyuan, String slZhuanye);

    //选课业务：成功返回true controller判断真值个数进行自增插入条目数。让前台提示插入成功几条
    boolean  insertXuankes(Coursespovo course , TbUserloginpovo tbUserloginpovo);

    List<CourseMessagePovo> getCourseMessageBYsomething(String key, String cXueyuan, String cZhuanye);

    List<CourseMessagePovo> getCourseMessage();

    List<YiXuan> selectYixuancourse(TbUserloginpovo userloginpovo);

    Boolean deleteYiXuan(String data);
}
