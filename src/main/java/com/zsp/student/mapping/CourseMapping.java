package com.zsp.student.mapping;

import com.zsp.student.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapping {
    public List<Coursespovo> selectAllCourse();

    List<Coursespovo> selectCourseByName(@Param(value="key") String key);

    List<Coursespovo> selectCourseBysomeThing(@Param(value="key") String key,@Param(value="cXueyuan") String cXueyuan, @Param(value="cZhuanye")String cZhuanye);
    //查询是否存在该id的课
    IshasCcoursepovo selectCourseByid (@Param(value = "xuanSlid") String cId, @Param(value = "xuanCourse") String course , @Param(value = "timeId") String timeId);
    //查询是否选该课程的人数大于30
    TeacherCourse selectRenshu(String tcId);
    //选课
    boolean insertXuancourse(TbXuanke tbXuanke);
    //选课成功修改人数
    boolean updateReanshu(@Param(value = "tcRenshu") String tcRenshu,@Param(value = "tcId") String tcId);

    List<CourseMessagePovo> selectCourseMessBysomeThing(@Param(value = "key") String key, @Param(value = "cXueyuan") String cXueyuan, @Param(value = "cZhuanye") String cZhuanye);

    List<CourseMessagePovo> selectAllCourseMess();

    List<YiXuan> selectYixuanCourseMap(@Param(value = "xuanSlid") String xuanSlid);

    Boolean deleteYiXuan(String data);
}
