package com.zsp.student.service;

import com.zsp.student.entity.ScorePovo;
import com.zsp.student.entity.TbUserloginpovo;
import com.zsp.student.mapping.ScoreMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/16:03/2019/11/14
 * @logNmae：zsp
 * @DO:
 */

public interface ScoreService {
    public TbUserloginpovo getMessage(Integer slUsername);
    public List<ScorePovo> selectMyscore(Integer slUsername);

    public List<ScorePovo> getAllscore();

    public  List<ScorePovo> getAllScoreBySomthing(String key, String slXueyuan, String slZhuanye);
}
