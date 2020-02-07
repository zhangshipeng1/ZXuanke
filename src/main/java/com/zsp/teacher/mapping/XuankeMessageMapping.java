package com.zsp.teacher.mapping;

import com.zsp.student.entity.Coursespovo;
import com.zsp.teacher.entity.Bingpovo;
import com.zsp.teacher.entity.Courseoptionpovo;
import com.zsp.teacher.entity.XuankethMesspovo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2020/12:19/2020/2/1
 * @logNmae：zsp
 * @DO:
 */
public interface XuankeMessageMapping {
    List<Bingpovo> selectBingData();

    List<XuankethMesspovo> getxuankedata(String username);

    List<XuankethMesspovo> getxuandataBYsomething(@Param(value = "key") String key,@Param(value = "cXueyuan") String slXueyuan,@Param(value = "cZhuanye") String slZhuanye,@Param(value = "username") String username,@Param(value = "cClass") String cClass);

    List<Courseoptionpovo> getcoursemapper(String sNumber);
}
