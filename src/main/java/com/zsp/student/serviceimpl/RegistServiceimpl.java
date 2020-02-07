package com.zsp.student.serviceimpl;

import com.zsp.admin.entity.TbAdministrator;
import com.zsp.admin.mapping.AdminMapping;
import com.zsp.student.entity.RegistPovo;
import com.zsp.student.entity.TbStudent;
import com.zsp.student.entity.TbTeacher;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.mapping.RegistMapping;
import com.zsp.student.mapping.TbStudentloginMapping;
import com.zsp.student.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.MakejiamiPass;

/**
 * @Author：张世朋
 * @Date：Create in2019/18:35/2019/12/25
 * @logNmae：zsp
 * @DO:
 */
@Service
public class RegistServiceimpl implements RegistService {
    @Autowired
    private RegistMapping registMapping;
    @Autowired
    private AdminMapping adminMapping;
    @Autowired
    private TbStudentloginMapping tbStudentloginMapping;
    //判断是否有这个人
    @Override
    public Boolean isHasById(String rNumber) {
        //先看教师信息存不存在注册的。
        if(rNumber!=null&&rNumber!=""){
                TbStudent tbStudent= registMapping.selectStudetById(rNumber);
                if(tbStudent!=null){
                    return true;
                }
                TbTeacher tbTeacher=registMapping.selectTeacherById(rNumber);
                if(tbTeacher!=null){
                    return true;
                }
            TbAdministrator administrator=adminMapping.selectAdminByUsername(rNumber);
                if(administrator!=null){
                    return true;
                }
        }
        //再看学生信息存不存在该信息。

        return false;
    }

    @Override
    public Boolean isHasUserName(String username) {
        if(username!=null&&username != ""){
            TbUserloginpovo tbUserloginpovo=tbStudentloginMapping.selectByUsername(username);
            if(tbUserloginpovo!=null){
                //存在用户
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean regist(RegistPovo registPovo) {
        //判斷是否该工号存在账号

        if(registPovo!=null){
        TbUserloginpovo tbUserloginpovo=new TbUserloginpovo();
        //根据用户名查出人脸数据id
        Integer faceid=registMapping.selectFaceIdByUsername(registPovo.getUsername());
        System.out.println(faceid);
        String tage=null;

        //根据学号查出学生或教师ID//学生1教师返回2管理返回3
        TbStudent student=registMapping.selectStudetById(registPovo.getNumber());
        TbTeacher teacher=registMapping.selectTeacherById(registPovo.getNumber());
        TbAdministrator administrator=adminMapping.selectAdminByUsername(registPovo.getNumber());
            int countnum=0;
        if(student!=null){
            countnum= registMapping.selectStuddentNumberCount(registPovo.getNumber());

            tbUserloginpovo.setSId(student.getSId());
            tage="学生";
        }
        if(teacher!=null){
            countnum= registMapping.selectTeacherNumberCount(registPovo.getNumber());
            tbUserloginpovo.setTId(teacher.gettId());
            tage="教师";
        }
        if(administrator!=null){
             countnum= registMapping.selectadminNumberCount(registPovo.getNumber());
            tbUserloginpovo.setAId(administrator.getAId());
            tage="管理员";
        }
        //根据123确定查询条件根据学生/老师/管理员条件查询
       //赋予相应职业权限填入id角色id
       int roalid=registMapping.selectRoalid(tage);


            //加密密码
            String pass= MakejiamiPass.getJiaMiPass(registPovo.getUsername(),registPovo.getPassword());
             //注册用户信息准备
            tbUserloginpovo.setSlUsername(registPovo.getUsername());
            tbUserloginpovo.setFaceId(faceid);
            tbUserloginpovo.setSlPassword(pass);
            tbUserloginpovo.setSlEmail(registPovo.getEmail());
            tbUserloginpovo.setPsCopy(registPovo.getPassword());
            tbUserloginpovo.setSlXueyuan(registPovo.getXueyuan());
            tbUserloginpovo.setSlZhuanye(registPovo.getZhuanye());
            tbUserloginpovo.setSlClass(registPovo.getBanji());
            if(countnum<1){
                Boolean isregist= registMapping.InsertUserMessage(tbUserloginpovo);

                //赋予权限
                Long id=tbStudentloginMapping.selectByUsername(tbUserloginpovo.getSlUsername()).getSlId();
                boolean is=  registMapping.initRoalpower(roalid,id);
                return isregist;
            }
            else{
                return false;
            }
        }
        return false;
    }
//注册失败是删除人脸信息
    @Override
    public Boolean delregistuserface(String data) {
        return registMapping.delregistuserface(data);
    }
}
