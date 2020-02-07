package com.zsp.student.mapping;

import com.zsp.student.entity.ScorePovo;
import com.zsp.student.entity.TbUserloginpovo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/15:34/2019/11/14
 * @logNmae：zsp
 * @DO:
 */
public interface ScoreMapping {
    public TbUserloginpovo selectUserMessage(Integer slUsername);
    public List<ScorePovo> selectmyScore(@Param(value = "slUsername") Integer slUsername );

   public  List<ScorePovo> selectAllscore();

    public List<ScorePovo> selectScoreBysomthing(@Param(value = "key") String key, @Param(value = "cXueyuan") String slXueyuan,@Param(value = "cZhuanye") String slZhuanye);
}
