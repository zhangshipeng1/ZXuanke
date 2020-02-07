package com.zsp.teacher.serviceimpl;

import com.zsp.student.mapping.ScoreMapping;
import com.zsp.teacher.entity.TbScorePovo;
import com.zsp.teacher.mapping.ThScoreMapping;
import com.zsp.teacher.service.ThScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：张世朋
 * @Date：Create in2020/18:26/2020/2/4
 * @logNmae：zsp
 * @DO:
 */
@Service
public class ThScoreServiceimpl implements ThScoreService {
    @Autowired
    private ThScoreMapping thScoreMapping;
    @Override
    public Boolean addScore(TbScorePovo tbScorePovo) {
       //查询sId
        Long sId=thScoreMapping.getSid(tbScorePovo.getsNumber());
        tbScorePovo.setsId(sId);


     TbScorePovo tbScorePovo1=   thScoreMapping.ishasScore(tbScorePovo);

        //不存在录入

        if(tbScorePovo1==null){

         Boolean isadd=   thScoreMapping.addScore(tbScorePovo);

         return  isadd;
        }

        return false;
    }

    @Override
    public Boolean upScore(TbScorePovo tbScorePovo) {
        TbScorePovo tbScoresByscid=   thScoreMapping.ishasScoreByscId(tbScorePovo.getScId());
        if(tbScoresByscid!=null){

            Boolean isadd=   thScoreMapping.upScore(tbScorePovo);

            return  isadd;
        }
        return false;
    }

    @Override
    public Boolean delScore(String scId) {
        TbScorePovo tbScoresByscid=   thScoreMapping.ishasScoreByscId(scId);
        if(tbScoresByscid!=null){

            Boolean isdel=   thScoreMapping.delScore(scId);
            System.out.println(isdel);
            return  isdel;
        }
        return false;
    }

    @Override
    public Boolean onlupScore(TbScorePovo tbScorePovo) {
        TbScorePovo tbScoresByscid=   thScoreMapping.ishasScoreByscId(tbScorePovo.getScId());
        if(tbScoresByscid!=null){

            Boolean isadd=   thScoreMapping.onlupScore(tbScorePovo);

            return  isadd;
        }
        return false;
    }

    @Override
    public Boolean onlupxuefen(TbScorePovo tbScorePovo) {
        TbScorePovo tbScoresByscid=   thScoreMapping.ishasScoreByscId(tbScorePovo.getScId());
        if(tbScoresByscid!=null){

            Boolean isadd=   thScoreMapping.onlupxuefen(tbScorePovo);

            return  isadd;
        }
        return false;
    }
}
