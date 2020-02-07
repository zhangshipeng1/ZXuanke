package com.zsp.teacher.service;

import com.zsp.student.entity.Coursespovo;
import com.zsp.teacher.entity.Bingpovo;
import com.zsp.teacher.entity.Courseoptionpovo;
import com.zsp.teacher.entity.XuankethMesspovo;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2020/11:58/2020/2/1
 * @logNmae：zsp
 * @DO:
 */

public interface XuankeMessageService {
    List<Bingpovo> getTuData();

    List<XuankethMesspovo> thgetCourseBYsomething(String cClass, String key, String slXueyuan, String slZhuanye, String username);

    List<XuankethMesspovo> thgetCourse(String username);

    List<Courseoptionpovo> getCourses(String sNumber);
}
