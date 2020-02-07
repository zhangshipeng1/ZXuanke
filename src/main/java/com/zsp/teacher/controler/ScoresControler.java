package com.zsp.teacher.controler;



import com.zsp.teacher.entity.TbScorePovo;
import com.zsp.teacher.service.ThScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：张世朋
 * @Date：Create in2020/18:10/2020/2/4
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping("/Score")
public class ScoresControler {
    @Autowired
   private ThScoreService thscoreService;
    @ResponseBody
    @RequestMapping("addscore.action")
    public Boolean addscore(TbScorePovo tbScorePovo){
        Boolean isadd=thscoreService.addScore(tbScorePovo);

        return isadd;
    }
    @ResponseBody
    @RequestMapping("upscore.action")
    public Boolean upscore(TbScorePovo tbScorePovo){
        Boolean isup=thscoreService.upScore(tbScorePovo);

        return isup;
    }
    @ResponseBody
    @RequestMapping("upscore2.action")
    public Boolean upscore2(TbScorePovo tbScorePovo){
        Boolean isup =false;
        if(tbScorePovo.getsScore()!=null && tbScorePovo.getsXuefen()==null){
          isup=  thscoreService.onlupScore(tbScorePovo);
        }
        if(tbScorePovo.getsScore()==null && tbScorePovo.getsXuefen()!=null){
            isup=  thscoreService.onlupxuefen(tbScorePovo);
        }


        return isup;
    }
    @ResponseBody
    @RequestMapping("delscore.action")
    public Boolean delscore(String scId){
        Boolean isdel=thscoreService.delScore(scId);
        System.out.println(isdel);
        return isdel;
    }
}
