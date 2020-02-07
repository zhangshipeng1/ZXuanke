package com.zsp.student.serviceimpl;

import com.zsp.student.entity.ScorePovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.mapping.ScoreMapping;
import com.zsp.student.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/16:08/2019/11/14
 * @logNmae：zsp
 * @DO:
 */
@Service
public class ScoreServiceimpl implements ScoreService {
    @Autowired
    private ScoreMapping scoreMapping;
    @Override
    public TbUserloginpovo getMessage(Integer slUsername) {
        TbUserloginpovo  tbUserloginpovo= scoreMapping.selectUserMessage(slUsername);

        return tbUserloginpovo;
    }

    @Override
    public List<ScorePovo> selectMyscore(Integer slUsername) {
        System.out.println(slUsername+"sssssssssssssssssssssssss");
        List<ScorePovo> scorePovos=scoreMapping.selectmyScore(slUsername);

        System.out.println(scorePovos+"sssssssssssssssssssssssss");

        return scorePovos;
    }

    @Override
    public List<ScorePovo> getAllscore() {
        return scoreMapping.selectAllscore();
    }

    @Override
    public List<ScorePovo> getAllScoreBySomthing(String key, String slXueyuan, String slZhuanye) {
        return scoreMapping.selectScoreBysomthing(key,slXueyuan,slZhuanye);
    }
}
