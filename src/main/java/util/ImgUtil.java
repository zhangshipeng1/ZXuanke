package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

/**
 * @PackageName:util
 * @ClassName:ImgUtil
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/26 21:35
 */
public class ImgUtil {
    public static BufferedImage getInputStream(String addr){
        try {
            String imgPath = addr;
            BufferedImage image = ImageIO.read(new FileInputStream (imgPath));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("获取图片异常:java.awt.image.BufferedImage");
            System.out.println("请检查图片路径是否正确，或者该地址是否为一个图片");
        }
        return null;
    }
}
