package com.zsp.teacher.entity;



/**
 * @Author：张世朋
 * @Date：Create in2020/18:19/2020/2/4
 * @logNmae：zsp
 * @DO:
 */
public class TbScorePovo extends TbScore {
    private String sNumber;

    @Override
    public String toString() {
        return "TbScorePovo{" +
                "sNumber='" + sNumber + '\'' +
                '}';
    }

    public TbScorePovo() {
    }

    public TbScorePovo(String sNumber) {
        this.sNumber = sNumber;
    }

    public TbScorePovo(long sId, String sCourse, double sScore, long sXuefen, String scId, String sNumber) {
        super(sId, sCourse, sScore, sXuefen, scId);
        this.sNumber = sNumber;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }
}
