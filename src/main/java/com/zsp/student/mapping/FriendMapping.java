package com.zsp.student.mapping;

import com.zsp.student.entity.Frindpovo;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/18:43/2019/11/18
 * @logNmae：zsp
 * @DO:
 */
public interface FriendMapping {
    List<Frindpovo> selectFrinds(String slUsername);


}
