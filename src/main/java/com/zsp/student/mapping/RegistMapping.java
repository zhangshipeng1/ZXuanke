package com.zsp.student.mapping;

import com.zsp.student.entity.TbStudent;
import com.zsp.student.entity.TbTeacher;
import com.zsp.student.entity.TbUserloginpovo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：张世朋
 * @Date：Create in2019/19:36/2019/12/25
 * @logNmae：zsp
 * @DO:
 */
public interface RegistMapping {
    int selectRoalid(String tage) ;

    TbStudent selectStudetById(String rNumber);

    TbTeacher selectTeacherById(String rNumber);

    Integer selectFaceIdByUsername(String username);

    Boolean InsertUserMessage(TbUserloginpovo tbUserloginpovo);

    boolean initRoalpower(@Param(value = "roalid") int roalid, @Param(value = "username") Long username);

    int selectStuddentNumberCount(String number);

    int selectTeacherNumberCount(String number);

    int selectadminNumberCount(String number);

    Boolean delregistuserface(String data);
}
