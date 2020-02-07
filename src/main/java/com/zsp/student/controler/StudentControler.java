package com.zsp.student.controler;

import cn.hutool.core.codec.Base64;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.zsp.student.entity.*;
import com.zsp.student.service.LoginService;
import com.zsp.student.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import util.CodeUtil;
import util.ImgUtil;
import util.TreeNodeBuilder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * @PackageName:com.zsp.student.controler
 * @ClassName:StudentControler
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/21 12:17
 */
@Controller
@RequestMapping("/student")

public class StudentControler {
    @Autowired
    private StudentService studentService;
    @Resource
    private LoginService loginService;


    @RequestMapping("/dologin.action")
    @ResponseBody
    public String dologin(@RequestParam(value = "username")  String slUsername , @RequestParam(value = "password") String slPassword, String code, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response){
         String code1= (String) session.getAttribute ("codedata");

        //  String data2= (String) request.getSession ().getAttribute ("codedata");
        System.out.println(code1+"......."+code);
        if(code1.equalsIgnoreCase (code)){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(slUsername,slPassword);

        try{
            //调用subject.login(token)进行登录，会自动委托给securityManager,调用之前
            subject.login(token);//会跳到我们自定义的realm中
            return "true";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("用户名或密码错误");
            //request.setAttribute("error", "用户名或密码错误");
            return "用户名或密码错误";
        }}
        else {

            return "验证码错误";
        }
    }

    @RequestMapping("/facelogin.action")
    @ResponseBody
    public String facelogin( String slUsername ,double simaler, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response){
        TbUserloginpovo tbUserloginpovo=loginService.userLogin (slUsername);
        String password=tbUserloginpovo.getPsCopy();
        System.out.println(password);
        if(simaler>80){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(slUsername,password);

            try{
                //调用subject.login(token)进行登录，会自动委托给securityManager,调用之前
                subject.login(token);//会跳到我们自定义的realm中

                return "true";
            }catch(Exception e){
                e.printStackTrace();

                //request.setAttribute("error", "用户名或密码错误");
                return "用户名或密码错误";
            }
        }else {
            return "人脸识别错误";
        }

    }
    //生成验证码
    @RequestMapping("/code.action")
    public void code(HttpServletRequest request, Model model,HttpServletResponse resp, HttpSession session){
        CodeUtil codeUtil=new CodeUtil ();
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic ();
      session.setAttribute("codedata",codeMap.get("code").toString());


        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
/*
*生成左侧列表
* ajax请求生成json树返回树
* 1请求路径
*
* */
@RequestMapping("/getTree.action")
    @ResponseBody
    public List<TreeNode> gettree(String username, Integer rId, HttpSession session){

    username= (String) SecurityUtils.getSubject ().getPrincipal ();
System.out.println(rId);
    UserRolPopovo userRolPopovo=new UserRolPopovo ();
    userRolPopovo.setSlUsername (username);
    userRolPopovo.setRoal (new Roal (rId));
       List<TreeNode> treeNodes= studentService.selectLefttree (userRolPopovo);


    return TreeNodeBuilder.builder (treeNodes,0);
    }

    /**
     *获取用户图片
     * @param session
     * @param request
     * @param response
     * @param slUsername
     */
    @RequestMapping("/getuserimg.action")
    @ResponseBody
    public void getUserloginmessage(HttpSession session , HttpServletRequest request,HttpServletResponse response,String slUsername ){
        TbUserloginpovo tbUserloginpovo=null;
System.out.println(slUsername);
        if(slUsername!=null){
            tbUserloginpovo=loginService.userLogin (slUsername);

         }else {
            tbUserloginpovo=loginService.userLogin ((String) SecurityUtils.getSubject ().getPrincipal ());

         }
        BufferedImage img = new BufferedImage(300, 150, BufferedImage.TYPE_INT_RGB);
        img = ImgUtil.getInputStream(tbUserloginpovo.getSlImg ());
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
       session.setAttribute ("tbuserlogin",tbUserloginpovo);


    }
    //获取student
    @RequestMapping("/getuser.action")
    @ResponseBody
    public TbUserloginpovo getUserlogin(HttpSession session , HttpServletRequest request,HttpServletResponse response){

        return loginService.userLogin ((String) SecurityUtils.getSubject ().getPrincipal ());

    }
    //获取用户信息显示
    @RequestMapping("/getloginmessage.action")
    @ResponseBody
    public UserMessagepovo getloginmessage(HttpSession session , HttpServletRequest request,HttpServletResponse response){
//不能从session中取值因为请求图片和请求用户在同一时间所以session中值没办法得到。
       TbUserloginpovo tbUserloginpovo= (TbUserloginpovo) session.getAttribute ("user");
       String username=tbUserloginpovo.getSlUsername ();

        return studentService.getuserMessage (username);

    }
    @RequestMapping("/updateuserlogMessage.action")
    @ResponseBody
    public boolean upuserlogMessage(UserMessagepovo userMessagepovo){

    Boolean res=studentService.updateuserMessage (userMessagepovo);
    return res;
    }
    @RequestMapping("/selectcolage.action")
    @ResponseBody
    public List<Collegepovo> selectcolage(){

        return studentService.selectcolage ();
    }
    @RequestMapping("/selectmajorByid.action")
    @ResponseBody
    public List<TbMajorpovo> selectmajorByid(String collegeId){
        return studentService.selectmajorByid (collegeId);
    }
    @RequestMapping("/selectclassesByid.action")
    @ResponseBody
    public List<TbClasspovo> selectclassesByid(String majorId){


        return studentService.selectclassesByid (majorId);
    }
    @RequestMapping("/selectroal.action")
    @ResponseBody
    public List<Roal> selectroal(String slUsername,HttpSession session){
      TbUserloginpovo tbUserloginpovo= (TbUserloginpovo) session.getAttribute ("user");

        return studentService.selectroelByusername (tbUserloginpovo.getSlUsername ());
    }
    private String base64Process(String base64Str) {
        if (!StringUtils.isEmpty(base64Str)) {
            String photoBase64 = base64Str.substring(0, 30).toLowerCase();
            int indexOf = photoBase64.indexOf("base64,");
            if (indexOf > 0) {
                base64Str = base64Str.substring(indexOf + 7);
            }

            return base64Str;
        } else {
            return "";
        }
    }
    }



