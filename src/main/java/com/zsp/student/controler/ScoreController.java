package com.zsp.student.controler;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsp.student.entity.Coursespovo;
import com.zsp.student.entity.Huizong;
import com.zsp.student.entity.ScorePovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/15:31/2019/11/14
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping(value = "/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/getMessage.action",produces = "application/json; charset=utf-8")
    @ResponseBody
    public TbUserloginpovo selectMessag(HttpSession session){
        TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");
       TbUserloginpovo tbUserloginpovo= scoreService.getMessage(Integer.parseInt(userloginpovo.getSlUsername()));
      System.out.println(tbUserloginpovo+"sssssasdds");
        return tbUserloginpovo;
    }
    @RequestMapping(value = "/getgerenScore.action",produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<ScorePovo> selectgerenScore(HttpSession session){
        TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee"+userloginpovo.getSlUsername());
        System.out.println(scoreService.selectMyscore(Integer.parseInt(userloginpovo.getSlUsername())));
       List<ScorePovo> scorePovos= scoreService.selectMyscore(Integer.parseInt(userloginpovo.getSlUsername()));
        return scorePovos;
    }
    @RequestMapping(value = "/dohuizong.action",produces = "application/json; charset=utf-8")
    @ResponseBody
    public Huizong dohuizong(HttpSession session){
        TbUserloginpovo userloginpovo=(TbUserloginpovo) session.getAttribute("user");
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee"+userloginpovo.getSlUsername());
        System.out.println(scoreService.selectMyscore(Integer.parseInt(userloginpovo.getSlUsername())));
        List<ScorePovo> scorePovos= scoreService.selectMyscore(Integer.parseInt(userloginpovo.getSlUsername()));
        double sum=0.0;
        double avg=0.0;
        int j=0;
        int zongxuefen=0;
        int gdian=0;
        double Gpa=0.0;
        Iterator<ScorePovo> iterator=scorePovos.iterator();
        while (iterator.hasNext()){
            ScorePovo scor=iterator.next();
          sum+= scor.getSScore();
          gdian+=scor.getSScore()*scor.getSXuefen();
          zongxuefen+=scor.getSXuefen();
          j++;
        }
        Gpa=(gdian*4)/(zongxuefen*100);
        avg=sum/j;
        Huizong huizong=new Huizong();
        huizong.setSum(sum);
        huizong.setAvg(avg);
        huizong.setGpa(Gpa);
        System.out.println(huizong);
        return huizong;
    }
    @RequestMapping(value = "/selectAllscore.action", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectAllscore(HttpServletResponse response, Integer page , Integer limit , String key, String slXueyuan, String slZhuanye){
        List<ScorePovo> scorePovos=null;

        response.setContentType ("application/json;charset=UTF-8");
        PageHelper.startPage (page,limit);

        if (key!=null||slXueyuan!=null||slZhuanye!=null){
            System.out.println("key"+key);
            scorePovos=scoreService.getAllScoreBySomthing(key,slXueyuan,slZhuanye);


        }else
        {
            scorePovos=  scoreService.getAllscore();

        }
        for (ScorePovo scorePovo: scorePovos
        ) {
            System.out.println("ssssssssssssss"+scorePovo.toString());
        }


        PageInfo info=new PageInfo (scorePovos);
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",info.getTotal());
        obj.put("data",scorePovos);
        return obj.toJSONString();


    }
}
