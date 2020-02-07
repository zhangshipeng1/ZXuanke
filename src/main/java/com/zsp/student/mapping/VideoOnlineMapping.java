package com.zsp.student.mapping;

import com.zsp.student.entity.VideoPovo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/8:19/2019/12/7
 * @logNmae：zsp
 * @DO:
 */
public interface VideoOnlineMapping {

    List<VideoPovo> selectVideos(@Param(value = "vJiename") String vJiename ,@Param(value = "pageSize") Integer pageSize,@Param(value = "pageNo") Integer pageNo);

    VideoPovo selectVideoImgUrl(@Param(value = "vJiename") String vJiename ,@Param(value = "vId") String vId);

    Integer getCount(@Param(value = "vJiename") String vJiename);

    List<VideoPovo> selectJiVideo(String vName);

    VideoPovo getvideoUrl(String vId);
}
