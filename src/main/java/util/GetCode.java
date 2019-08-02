package util;

import org.apache.tools.ant.taskdefs.condition.Http;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @PackageName:util
 * @ClassName:GetCode
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/21 15:48
 */
public class GetCode {
    public static void getcode(HttpServletRequest request, HttpServletResponse resp, HttpSession session){
        CodeUtil codeUtil=new CodeUtil ();
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic ();
        session.setAttribute("codedata", codeMap.get("code").toString());
          System.out.println(session.getAttribute ("codedata"));
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
    }

