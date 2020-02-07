package com.zsp.student.controler;

import com.zsp.student.entity.Page;
import com.zsp.student.entity.TbUserlogin;
import com.zsp.student.entity.VideoPovo;
import com.zsp.student.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ImgUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/8:32/2019/12/7
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @RequestMapping(value = "/getAllvideo.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<VideoPovo>  getAllvideo(@RequestParam(defaultValue = "001") String vJiename,@RequestParam(defaultValue = "10")Integer pageSize,@RequestParam(defaultValue = "1")Integer pageNo){

        List<VideoPovo> videoPovos=videoService.getAllvideo(vJiename,pageSize,pageNo-1);
        return videoPovos;
    }
    @RequestMapping("/getvideo.action")
    public String getVideo(VideoPovo video , String vName, HttpSession session){
        System.out.println(vName+"888888888888888");
        session.setAttribute("name",vName);
        return "page/studentpage/showVideo";
    }
    @RequestMapping("/getJivideo.action")
    @ResponseBody
    public List<VideoPovo> getJivideo(HttpSession session){
       String vName=(String) session.getAttribute("name");
        List<VideoPovo> videoPos=videoService.getJiVideo(vName);
        return videoPos;
    }
    @RequestMapping("/getvideoUrl.action")
    @ResponseBody
    public VideoPovo getvideoUrl(String vId){
        System.out.println(vId+"sssssssssssssssssssssssssssssssss");
        VideoPovo videoPo=videoService.getvideoUrl(vId);
        System.out.println(videoPo+"sssssssssssssssssssssssssssssssss");
        return videoPo;
    }
    @RequestMapping(value = "/getTotle.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Integer  getTotle(@RequestParam(defaultValue = "001") String vJiename){
      Integer count=videoService.getTotle(vJiename);
        return count;
    }
    @RequestMapping("/getimg.action")
    public void getimage(HttpServletResponse response,@RequestParam(defaultValue = "001") String vJiename,String vId){
        System.out.println(vJiename+vId);
        VideoPovo videoPovo=videoService.getvideoImg(vJiename,vId);
        BufferedImage img = new BufferedImage(300, 150, BufferedImage.TYPE_INT_RGB);
        img = ImgUtil.getInputStream(videoPovo.getvImg());
        if(img==null){
            throw new RuntimeException("打印图片异常：com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
        }
        if(img!=null){
            try {
                ImageIO.write(img, "JPEG", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("打印异常:com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
            }
        }
    }


}
