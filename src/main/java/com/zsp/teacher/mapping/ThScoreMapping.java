package com.zsp.teacher.mapping;

import com.zsp.teacher.entity.TbScorePovo;

/**
 * @Author：张世朋
 * @Date：Create in2020/18:49/2020/2/4
 * @logNmae：zsp
 * @DO:
 */
public interface ThScoreMapping {
    Long getSid(String sNumber);

    TbScorePovo ishasScore(TbScorePovo tbScorePovo);

    Boolean addScore(TbScorePovo tbScorePovo);

    TbScorePovo ishasScoreByscId(String scId);

    Boolean upScore(TbScorePovo tbScorePovo);

    Boolean delScore(String scId);

    Boolean onlupScore(TbScorePovo tbScorePovo);

    Boolean onlupxuefen(TbScorePovo tbScorePovo);
}
