package com.zsp.student.serviceimpl;

import com.zsp.student.entity.Coursespovo;
import com.zsp.student.mapping.CourseMapping;
import com.zsp.student.service.CourseService;
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

    @Override
    public List<Coursespovo> getCourseByName(String key) {
        return cousermaMapping.selectCourseByName(key);
    }

    @Override
    public List<Coursespovo> getCourseBYsomething(String key,String slXueyuan, String slZhuanye) {
        return cousermaMapping.selectCourseBysomeThing(key,slXueyuan,slZhuanye);
    }
}
