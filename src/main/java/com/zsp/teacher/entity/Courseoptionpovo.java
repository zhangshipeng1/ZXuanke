package com.zsp.teacher.entity;

/**
 * @Author：张世朋
 * @Date：Create in2020/21:03/2020/2/3
 * @logNmae：zsp
 * @DO:
 */
public class Courseoptionpovo {
    private Integer cId;
    private String cCname;

    @Override
    public String toString() {
        return "Courseoptionpovo{" +
                "cId=" + cId +
                ", cCname='" + cCname + '\'' +
                '}';
    }

    public Courseoptionpovo() {
    }

    public Courseoptionpovo(Integer cId, String cCname) {
        this.cId = cId;
        this.cCname = cCname;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcCname() {
        return cCname;
    }

    public void setcCname(String cCname) {
        this.cCname = cCname;
    }
}
