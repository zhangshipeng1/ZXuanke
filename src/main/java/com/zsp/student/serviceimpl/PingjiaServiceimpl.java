package com.zsp.student.serviceimpl;

import com.alibaba.druid.sql.ast.SQLName;
import com.zsp.student.entity.PingjiaPovo;
import com.zsp.student.mapping.PingJiaMapping;
import com.zsp.student.service.PingjiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：张世朋
 * @Date：Create in2019/9:53/2019/12/11
 * @logNmae：zsp
 * @DO:
 */
@Service

public class PingjiaServiceimpl implements PingjiaService {
@Autowired
    private PingJiaMapping pingJiaMapping;
    @Override
    public Boolean InPingJia(PingjiaPovo pingjiaPovo) {
     String sid= pingJiaMapping.getsId(pingjiaPovo.getsUsername());
     String tId=pingJiaMapping.getTid(sid,pingjiaPovo.gettName(),pingjiaPovo.gettCourese());

        pingjiaPovo.setSId(sid);
        pingjiaPovo.setTId(tId);
        if(sid!=null && tId!=null && pingjiaPovo!=null &&pingjiaPovo.gettCourese()!=null){
            return pingJiaMapping.InPingja(pingjiaPovo);
        }
        return false;

    }
}
