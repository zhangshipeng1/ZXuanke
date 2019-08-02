package com.zsp.student.service;

import com.zsp.student.entity.*;

import java.util.List;

public interface StudentService {
    public List<TreeNode> selectLefttree(StuRolPopovo stuRolPopovo);
    public boolean updateImg(String img);
    public StudentMessagepovo getStudentMessage(String username);
    public boolean updatestudentMessage(StudentMessagepovo studentMessagepovo);
    public List<Collegepovo> selectcolage();

    public List<TbMajorpovo> selectmajorByid(String collegeId);

    List<TbClasspovo> selectclassesByid(String majorId);
}
