package com.zsp.student.entity;

import java.io.Serializable;

/**
 * @PackageName:com.zsp.student.entity
 * @ClassName:SelectleftTree
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/26 11:23
 */
public class SelectleftTree implements Serializable {
    private static final long serialVersionID=10021890L;
    private Roal roal;
    private TbUserloginpovo tbUserloginpovo;
    private Power power;

    @Override
    public String toString() {
        return "SelectleftTree{" +
                "roal=" + roal +
                ", tbUserloginpovo=" + tbUserloginpovo +
                ", power=" + power +
                '}';
    }

    public SelectleftTree() {
    }

    public SelectleftTree(Roal roal, TbUserloginpovo tbUserloginpovo, Power power) {
        this.roal = roal;
        this.tbUserloginpovo = tbUserloginpovo;
        this.power = power;
    }

    public Roal getRoal() {
        return roal;
    }

    public void setRoal(Roal roal) {
        this.roal = roal;
    }

    public TbUserloginpovo getTbUserloginpovo() {
        return tbUserloginpovo;
    }

    public void setTbUserloginpovo(TbUserloginpovo tbUserloginpovo) {
        this.tbUserloginpovo = tbUserloginpovo;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
