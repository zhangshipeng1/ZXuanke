package util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author：张世朋
 * @Date：Create in2019/22:17/2019/12/28
 * @logNmae：zsp
 * @DO:
 */
public class MakejiamiPass {
 public static String getJiaMiPass(String username,String password){
        ByteSource salt=ByteSource.Util.bytes(username);

        SimpleHash sh=new SimpleHash("MD5", password, salt, 1024);
        return  sh.toString();
    }
}
