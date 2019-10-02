package com.zsp.student.mapping;

import com.zsp.student.entity.Coursespovo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapping {
    public List<Coursespovo> selectAllCourse();

    List<Coursespovo> selectCourseByName(@Param(value="key") String key);

    List<Coursespovo> selectCourseBysomeThing(@Param(value="key") String key,@Param(value="cXueyuan") String cXueyuan, @Param(value="cZhuanye")String cZhuanye);
}
