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
    public List<TreeNode> selectLefttree(StuRolPopovo stuRolPopovo1) {
        System.out.println("service*****"+stuRolPopovo1.getSlUsername ());
        List<StuRolPopovo> tbStudentloginpovos=leftTreeMapping.SelectPowerByUsername (stuRolPopovo1);
        System.out.println("tbStudentloginpovos"+tbStudentloginpovos);
        List<TreeNode> treeNodes=new ArrayList<> ();
        for (StuRolPopovo stuRolPopovo:tbStudentloginpovos) {
            System.out.println(stuRolPopovo);
            System.out.println(stuRolPopovo.getPower());
            boolean Spread=stuRolPopovo.getPower().getpSpread()==1?true:false;
            treeNodes.add (new TreeNode (stuRolPopovo.getPower ().getpId (),stuRolPopovo.getPower ().getpFtherid (),stuRolPopovo.getPower ().getpName (),stuRolPopovo.getPower ().getpIcon (),stuRolPopovo.getPower ().getpUrl (),Spread));
        }
        return treeNodes;
    }

    @Override
    public boolean updateImg(String img) {
        return tbStudentloginMapping.updateStudentimg (img);
    }

    @Override
    public StudentMessagepovo getStudentMessage(String username) {
        System.out.println("///////////////////////"+username);
        System.out.println("//////////////////"+tbStudentloginMapping.selectStudentmessage (username));
        return  tbStudentloginMapping.selectStudentmessage (username);

    }



    //修改用户信息
  @Override
    public boolean updatestudentMessage(StudentMessagepovo studentMessagepovo) {
        return tbStudentloginMapping.updatestudentmMessage (studentMessagepovo);
    }

    @Override
    public List<Collegepovo> selectcolage() {
        return tbStudentloginMapping.selectAllcolage ();
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
