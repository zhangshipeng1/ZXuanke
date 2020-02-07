package com.zsp.student.service;

import com.zsp.student.entity.RegistPovo;

/**
 * @Author：张世朋
 * @Date：Create in2019/18:34/2019/12/25
 * @logNmae：zsp
 * @DO:
 */
public interface RegistService {
    public Boolean isHasById(String rNumber);

    public  Boolean isHasUserName(String username);

    Boolean regist(RegistPovo registPovo);

    Boolean delregistuserface(String data);
}
