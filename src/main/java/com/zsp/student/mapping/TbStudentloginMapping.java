package com.zsp.student.mapping;
import com.zsp.student.entity.*;

import java.util.List;

public interface TbStudentloginMapping {
        //登录前查询有没有此用户，有返回数据对象
        public TbStudentlogin selectByUsername(String slUsername);
        public boolean updateStudentimg(String slImg);
        public StudentMessagepovo selectStudentmessage(String slUsername);
        public boolean updatestudentmMessage(StudentMessagepovo studentMessagepovo);
        public List<Collegepovo> selectAllcolage();
        public List<TbMajorpovo> selectmajorByid(String collegeId);
        List<TbClasspovo> selectclassesByid(String majorId);
}
