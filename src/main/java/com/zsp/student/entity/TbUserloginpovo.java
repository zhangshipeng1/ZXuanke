package com.zsp.student.entity;

/**
 * @PackageName:com.zsp.student.entity
 * @ClassName:TbUserloginpovo
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/4 7:36
 */
public class TbUserloginpovo extends TbUserlogin {
    private TbMajor tbMajor;
    private College college;
    private TbStudent tbStudent;

    @Override
    public String toString() {
        return "TbUserloginpovo{" +
                "tbMajor=" + tbMajor +
                ", college=" + college +
                ", tbStudent=" + tbStudent +
                '}';
    }

    public TbUserloginpovo() {
    }

    public TbMajor getTbMajor() {
        return tbMajor;
    }

    public TbUserloginpovo(TbMajor tbMajor, College college, TbStudent tbStudent) {
        this.tbMajor = tbMajor;
        this.college = college;
        this.tbStudent = tbStudent;
    }

    public void setTbMajor(TbMajor tbMajor) {
        this.tbMajor = tbMajor;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public TbStudent getTbStudent() {
        return tbStudent;
    }

    public void setTbStudent(TbStudent tbStudent) {
        this.tbStudent = tbStudent;
    }
}
