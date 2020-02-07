package com.zsp.student.serviceimpl;

import com.zsp.student.entity.VideoPovo;
import com.zsp.student.mapping.VideoOnlineMapping;
import com.zsp.student.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/8:50/2019/12/7
 * @logNmae：zsp
 * @DO:
 */
@Service
public class VideoServiceimpl implements VideoService {
@Autowired
    VideoOnlineMapping videoOnlineMapping;
    @Override
    public List<VideoPovo> getAllvideo(String vJiename,Integer pageSize,Integer pageNo) {

        List<VideoPovo> videoPovos=videoOnlineMapping.selectVideos(vJiename,pageSize,pageNo);
        return videoPovos;
    }

    @Override
    public VideoPovo getvideoImg(String vJiename,String vId) {
        return videoOnlineMapping.selectVideoImgUrl(vJiename,vId);

    }

    @Override
    public Integer getTotle(String vJiename) {
        return videoOnlineMapping.getCount(vJiename);
    }

    @Override
    public List<VideoPovo> getJiVideo(String vName) {
        return videoOnlineMapping.selectJiVideo(vName);
    }

    @Override
    public VideoPovo getvideoUrl(String vId) {
        return videoOnlineMapping.getvideoUrl(vId);
    }
}
