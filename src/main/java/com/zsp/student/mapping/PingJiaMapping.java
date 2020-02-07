package com.zsp.student.mapping;

import com.zsp.student.entity.PingjiaPovo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：张世朋
 * @Date：Create in2019/10:07/2019/12/11
 * @logNmae：zsp
 * @DO:
 */
public interface PingJiaMapping {
    String getsId(@Param("username") String username);

    String getTid(@Param("sId") String sid, @Param("tName") String tName, @Param("tCourese") String tCourese);

    Boolean InPingja(PingjiaPovo pingjiaPovo);
}
