package com.zsp.student.service;

import com.zsp.student.entity.Frindpovo;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/19:58/2019/12/1
 * @logNmae：zsp
 * @DO:
 */
public interface FrindService {

  List<Frindpovo> selectFrind(String username) ;
}
