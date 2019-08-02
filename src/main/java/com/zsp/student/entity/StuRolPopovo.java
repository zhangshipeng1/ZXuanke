package com.zsp.student.entity;

/**
 * @PackageName:com.zsp.student.entity
 * @ClassName:StuRolPopovo
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/26 11:17
 */
public class StuRolPopovo extends TbStudentlogin{
   private Roal roal;
   private Power power;

    public StuRolPopovo() {
    }

    public StuRolPopovo(Roal roal, Power power) {
        this.roal = roal;
        this.power = power;
    }

    public Roal getRoal() {
        return roal;
    }

    @Override
    public String toString() {
        return "StuRolPopovo{" +
                "roal=" + roal +
                ", power=" + power +
                '}';
    }

    public void setRoal(Roal roal) {
        this.roal = roal;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
