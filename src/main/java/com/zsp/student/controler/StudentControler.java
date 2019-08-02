package com.zsp.student.controler;

import com.zsp.student.entity.*;
import com.zsp.student.service.LoginService;
import com.zsp.student.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.CodeUtil;
import util.GetCode;
import util.ImgUtil;
import util.TreeNodeBuilder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jws.WebParam;
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
    public String dologin(@RequestParam(value = "username")  String slUsername , @RequestParam(value = "password") String slPassword, String code, @RequestParam(value = "remberme",defaultValue = "false") Boolean remberme , HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response){
         String code1= (String) session.getAttribute ("codedata");

       //  String data2= (String) request.getSession ().getAttribute ("codedata");
        System.out.println(code1+"......."+code);
        if(code1.equalsIgnoreCase (code)){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(slUsername,slPassword);
        if(!token.isRememberMe ()){System.out.println("rem1");
            if(remberme){
                System.out.println("rem2");
                //token.setRememberMe (true);
            }
        }
            System.out.println("rem3");
        try{
            //调用subject.login(token)进行登录，会自动委托给securityManager,调用之前
            subject.login(token);//会跳到我们自定义的realm中
            System.out.println("rem3"+".......");
            return "true";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("用户名或密码错误");
            //request.setAttribute("error", "用户名或密码错误");
            return "用户名或密码错误";
        }}
        else {

            return "code roung";
        }
    }
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
* ajax请求生成json树返回树
* 1请求路径
*
* */
@RequestMapping("/getTree.action")
    @ResponseBody
    public List<TreeNode> gettree(String username, HttpSession session){

    username= (String) SecurityUtils.getSubject ().getPrincipal ();

    StuRolPopovo stuRolPopovo=new StuRolPopovo ();
    stuRolPopovo.setSlUsername (username);
       List<TreeNode> treeNodes= studentService.selectLefttree (stuRolPopovo);


    return TreeNodeBuilder.builder (treeNodes,0);
    }
    @RequestMapping("/getuserimg.action")
    @ResponseBody
    public void getUserloginmessage(HttpSession session , HttpServletRequest request,HttpServletResponse response,String slUsername ){
        TbStudentlogin tbStudentlogin=null;
System.out.println(slUsername);
        if(slUsername!=null){
            tbStudentlogin=loginService.StudentLogin (slUsername);

         }else {
            tbStudentlogin=loginService.StudentLogin ((String) SecurityUtils.getSubject ().getPrincipal ());

         }
        BufferedImage img = new BufferedImage(300, 150, BufferedImage.TYPE_INT_RGB);
        img = ImgUtil.getInputStream(tbStudentlogin.getSlImg ());
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
       session.setAttribute ("tbStudentlogin",tbStudentlogin);


    }
    //获取student
    @RequestMapping("/getuser.action")
    @ResponseBody
    public TbStudentlogin getUserlogin(HttpSession session , HttpServletRequest request,HttpServletResponse response){

        return loginService.StudentLogin ((String) SecurityUtils.getSubject ().getPrincipal ());

    }
    //获取用户信息显示
    @RequestMapping("/getloginmessage.action")
    @ResponseBody
    public StudentMessagepovo getloginmessage(HttpSession session , HttpServletRequest request,HttpServletResponse response){
//不能从session中取值因为请求图片和请求用户在同一时间所以session中值没办法得到。
       TbStudentlogin tbStudentlogin= (TbStudentlogin) session.getAttribute ("tbStudentlogin");
       String username=tbStudentlogin.getSlUsername ();
       System.out.println("************************"+username);
       System.out.println(studentService.getStudentMessage (username));
        return studentService.getStudentMessage (username);

    }
    @RequestMapping("/updateStudentlogMessage.action")
    @ResponseBody
    public boolean upStudentlogMessage(StudentMessagepovo studentMessagepovo){
    System.out.println(studentMessagepovo);
    Boolean res=studentService.updatestudentMessage (studentMessagepovo);
    return res;
    }
    @RequestMapping("/selectcolage.action")
    @ResponseBody
    public List<Collegepovo> selectcolage(){
    System.out.println(studentService.selectcolage ());
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
    System.out.println("+++++++"+majorId);
    System.out.println(studentService.selectclassesByid (majorId));

        return studentService.selectclassesByid (majorId);
    }
    }



