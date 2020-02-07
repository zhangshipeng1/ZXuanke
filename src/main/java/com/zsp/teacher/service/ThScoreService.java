package com.zsp.teacher.service;

import com.zsp.teacher.entity.TbScorePovo;

/**
 * @Author：张世朋
 * @Date：Create in2020/18:25/2020/2/4
 * @logNmae：zsp
 * @DO:
 */
public interface ThScoreService {
    Boolean addScore(TbScorePovo tbScorePovo);

    Boolean upScore(TbScorePovo tbScorePovo);

    Boolean delScore(String scId);

    Boolean onlupScore(TbScorePovo tbScorePovo);

    Boolean onlupxuefen(TbScorePovo tbScorePovo);
}
