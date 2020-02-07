package com.zsp.teacher.serviceimpl;

import com.zsp.student.entity.Coursespovo;
import com.zsp.teacher.entity.Bingpovo;
import com.zsp.teacher.entity.Courseoptionpovo;
import com.zsp.teacher.entity.XuankethMesspovo;
import com.zsp.teacher.mapping.XuankeMessageMapping;
import com.zsp.teacher.service.XuankeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2020/12:04/2020/2/1
 * @logNmae：zsp
 * @DO:
 */
@Service
public class XuankeMessageServiceimpl implements XuankeMessageService {
    @Autowired
    private XuankeMessageMapping xuankeMessageMapping;
    @Override
    public List<Bingpovo> getTuData() {
        return xuankeMessageMapping.selectBingData();
    }

    @Override
    public List<XuankethMesspovo> thgetCourseBYsomething(String cClass, String key, String slXueyuan, String slZhuanye, String username) {
        System.out.println("service"+slXueyuan+slZhuanye+cClass);
        return xuankeMessageMapping.getxuandataBYsomething(key,slXueyuan,slZhuanye,username,cClass);
    }

    @Override
    public List<XuankethMesspovo> thgetCourse(String username) {
        return xuankeMessageMapping.getxuankedata(username);
    }

    @Override
    public List<Courseoptionpovo> getCourses(String sNumber) {
        return xuankeMessageMapping.getcoursemapper(sNumber);
    }
}
