package com.zsp.student.mapping;
import com.zsp.student.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbStudentloginMapping {
        //登录前查询有没有此用户，有返回数据对象
        public TbUserloginpovo selectByUsername(String slUsername);
        public boolean updateUserimg(@Param("slImg") String slImg,@Param("username") String username);
        public UserMessagepovo selectusermessage(String slUsername);
        public boolean updateusermMessage(UserMessagepovo userMessagepovo);
        public List<Collegepovo> selectAllcolage();
        public List<TbMajorpovo> selectmajorByid(String collegeId);
        List<TbClasspovo> selectclassesByid(String majorId);
        List<Roal> slelectRoleByusername(String slUsername);
}
