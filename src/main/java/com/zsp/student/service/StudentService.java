package com.zsp.student.service;

import com.zsp.student.entity.*;

import java.util.List;

public interface StudentService {
    public List<TreeNode> selectLefttree(UserRolPopovo userRolPopovo);
    public boolean updateImg(String img);
    public UserMessagepovo getuserMessage(String username);
    public boolean updateuserMessage(UserMessagepovo userMessagepovo);
    public List<Collegepovo> selectcolage();
    List<Roal> selectroelByusername(String slUsername);
    public List<TbMajorpovo> selectmajorByid(String collegeId);

    List<TbClasspovo> selectclassesByid(String majorId);
}
