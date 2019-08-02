package com.zsp.student.entity;

/**
 * @PackageName:com.zsp.student.entity
 * @ClassName:SelectleftTree
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/26 11:23
 */
public class SelectleftTree {
    private Roal roal;
    private TbStudentloginpovo tbStudentloginpovo;
    private Power power;

    @Override
    public String toString() {
        return "SelectleftTree{" +
                "roal=" + roal +
                ", tbStudentloginpovo=" + tbStudentloginpovo +
                ", power=" + power +
                '}';
    }

    public SelectleftTree() {
    }

    public SelectleftTree(Roal roal, TbStudentloginpovo tbStudentloginpovo, Power power) {
        this.roal = roal;
        this.tbStudentloginpovo = tbStudentloginpovo;
        this.power = power;
    }

    public Roal getRoal() {
        return roal;
    }

    public void setRoal(Roal roal) {
        this.roal = roal;
    }

    public TbStudentloginpovo getTbStudentloginpovo() {
        return tbStudentloginpovo;
    }

    public void setTbStudentloginpovo(TbStudentloginpovo tbStudentloginpovo) {
        this.tbStudentloginpovo = tbStudentloginpovo;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
