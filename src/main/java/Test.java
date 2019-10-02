import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;





public class Test {
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
      Iterator<Double> iter=xList.iterator ();
      Iterator<Double> iter1=yList.iterator ();
      double maxx=0.0;
      double minx=0.0;
      double maxy=0.0;
      double miny=0.0;
        for (Double sa:xList
        ) {
            System.out.println("sss"+sa);
        }
        double a;
      while (iter.hasNext ()) {
         double b=iter.next ();
         if(maxx<b){
             maxx=b;
         }else if(minx>b){
             minx=b;
         }

      }
        double key = 0;
        while (iter1.hasNext ()) {
            double b=iter1.next ();
            if(maxy<b){
                maxy=b;
            }else if(miny>b){
                miny=b;
            }

        }

        if(x>maxx||x<minx||y>maxy||y<miny){

       if(x>maxx){
           key=x-maxx;
           if(y>maxy){
               key=(y-maxy)+(x-maxx);
           }

       }else if(x<minx){
           key=x-minx;
       }else if(y>maxy){
           key=y-maxy;
           if(y<miny){
               key=y-miny+y-maxy;

           }
       }else  if(y<miny){
           key=y-miny;

       }
            return "no"+key;
        }
       return "yes"+0;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<> ();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }

        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}/*
*/
/*//*
*/
/*

    }*//*

    // 短信应用SDK AppID
    static int appid = 1400xxxxx; // 1400开头
    // 短信应用SDK AppKey
    static String appkey = "xxxxxxxxxx";
    // 需要发送短信的手机号码
    static String[] phoneNumbers = { "xxxxxxxx" };
    // 短信模板ID，需要在短信应用中申请
    int templateId = xxxxx; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    // 签名
    String smsSign = "阿宁电影"; // NOTE:
    // 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
    public static void main(String[] args) {
        try {
            SmsSingleSender ssender = new SmsSingleSender (appid, appkey);
            //模板内容必须和这里一直，要不然报错
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0], "324562为您的登录验证码，请于2分钟内填写。如非本人操作，请忽略本短信。", "", "");
        } catch (HTTPException e) {// HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {// json解析错误
            e.printStackTrace();
        } catch (IOException e) {// 网络IO错误
            e.printStackTrace();
        }
    }*/


