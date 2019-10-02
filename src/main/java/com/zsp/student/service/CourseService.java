package com.zsp.student.service;

import com.zsp.student.entity.Coursespovo;

import java.util.List;

public interface CourseService {
    List<Coursespovo> getCourse();

    List<Coursespovo> getCourseByName(String key);

    List<Coursespovo> getCourseBYsomething(String key,String slXueyuan, String slZhuanye);
}
