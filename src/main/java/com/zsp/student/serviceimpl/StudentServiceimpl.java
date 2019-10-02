package com.zsp.student.serviceimpl;

import com.zsp.student.entity.*;
import com.zsp.student.mapping.LeftTreeMapping;
import com.zsp.student.mapping.TbStudentloginMapping;
import com.zsp.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.zsp.student.serviceimpl
 * @ClassName:StudentServiceimpl
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/26 12:12
 */
@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
    private LeftTreeMapping leftTreeMapping;
    @Autowired
    private TbStudentloginMapping tbStudentloginMapping;
    @Override
    public List<TreeNode> selectLefttree(UserRolPopovo userRolPopovo1) {
        System.out.println("service*****"+userRolPopovo1.getSlUsername ());
        List<UserRolPopovo> tbStudentloginpovos=leftTreeMapping.SelectPowerByUsername (userRolPopovo1);
        System.out.println("tbStudentloginpovos"+tbStudentloginpovos);
        List<TreeNode> treeNodes=new ArrayList<> ();
        for (UserRolPopovo userRolPopovo:tbStudentloginpovos) {
            System.out.println(userRolPopovo);
            System.out.println(userRolPopovo.getPower());
            boolean Spread=userRolPopovo.getPower().getpSpread()==1?true:false;
            treeNodes.add (new TreeNode (userRolPopovo.getPower ().getpId (),userRolPopovo.getPower ().getpFtherid (),userRolPopovo.getPower ().getpName (),userRolPopovo.getPower ().getpIcon (),userRolPopovo.getPower ().getpUrl (),Spread));
        }
        return treeNodes;
    }

    @Override
    public boolean updateImg(String img) {
        return tbStudentloginMapping.updateUserimg (img);
    }

    @Override
    public UserMessagepovo getuserMessage(String username) {
        System.out.println("///////////////////////"+username);
        System.out.println("//////////////////"+tbStudentloginMapping.selectusermessage(username));
        return  tbStudentloginMapping.selectusermessage (username);

    }



    //修改用户信息
  @Override
    public boolean updateuserMessage(UserMessagepovo userMessagepovo) {
        return tbStudentloginMapping.updateusermMessage (userMessagepovo);
    }

    @Override
    public List<Collegepovo> selectcolage() {
        return tbStudentloginMapping.selectAllcolage ();
    }

    @Override
    public List<Roal> selectroelByusername(String slUsername) {
      return   tbStudentloginMapping.slelectRoleByusername (slUsername);

    }

    @Override
    public List<TbMajorpovo> selectmajorByid(String collegeId) {
        return tbStudentloginMapping.selectmajorByid (collegeId);
    }

    @Override
    public List<TbClasspovo> selectclassesByid(String majorId) {
        return tbStudentloginMapping.selectclassesByid (majorId);
    }
}
