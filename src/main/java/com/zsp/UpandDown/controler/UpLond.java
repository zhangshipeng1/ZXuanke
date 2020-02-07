package com.zsp.UpandDown.controler;

import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.service.StudentService;
import javafx.scene.chart.PieChart;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @PackageName:com.zsp.UpandDown.controler
 * @ClassName:UpLond
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/27 16:00
 */
@Controller
public class UpLond {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/upuserimg.action")
    @ResponseBody
    public Map<String,Object> handleFormUpload(MultipartFile file, HttpSession session ) throws IOException {

        TbUserloginpovo tbUserloginpovo= (TbUserloginpovo) session.getAttribute ("user");
        String username=tbUserloginpovo.getSlUsername ();
        String filename = file.getOriginalFilename ();
        String uuid= UUID.randomUUID ().toString ().trim ().replace ("-","").toUpperCase ();

        String  type=filename.substring (filename.lastIndexOf (".")+1);
        Date date=new Date ();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat ("yyyy-MM-dd@HH-mm-ss");
        String date1=simpleDateFormat.format(date);
        String path="c:\\Zxuankeimg\\image";
        File makefile=new File (path);
        if((type.length ()+1)!=filename.length ()) {//判断是否“.”之前有值
           if(!makefile.exists ()){
               makefile.mkdirs ();
           }
        }
        String path1=path+"\\"+uuid+ SecurityUtils.getSubject ().getPrincipal ()+filename;
        file.transferTo (new File (path1));
        Map<String,Object> map=new HashMap<> ();
        map.put ("srcimg","../../student/getuserimg.action");
        boolean isup=studentService.updateImg (path1,username);
        if(isup==true){
            map.put ("msge","上传成功");
        }else{
            map.put ("msge","上传失败请检查图片");
        }
        return map;
        }


}
