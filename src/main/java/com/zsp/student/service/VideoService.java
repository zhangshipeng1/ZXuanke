package com.zsp.student.service;

import com.zsp.student.entity.VideoPovo;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/8:34/2019/12/7
 * @logNmae：zsp
 * @DO:
 */
public interface VideoService {

    public List<VideoPovo> getAllvideo(String vJiename,Integer pageSize,Integer pageNo) ;

    VideoPovo getvideoImg(String vJiename ,String vId);

    Integer getTotle(String vJiename);

    List<VideoPovo> getJiVideo(String vName);

    VideoPovo getvideoUrl(String vId);
}
