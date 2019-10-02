package com.zsp.student.entity;

/**
 * @PackageName:com.zsp.student.entity
 * @ClassName:StudentMessagepovo
 * @Description:
 * @Author 张世朋
 * @Data 2019/7/30 20:32
 */
public class UserMessagepovo extends TbUserlogin {
    private Roal roal;
    private TbAddress tbAddress;
    private TbStudent tbStudent;
    private  TbClass tbClass;
    private TbMajor tbMajor;
    private College college;

    @Override
    public String toString() {
        return "UserMessagepovo{" +
                "roal=" + roal +
                ", tbAddress=" + tbAddress +
                ", tbStudent=" + tbStudent +
                ", tbClass=" + tbClass +
                ", tbMajor=" + tbMajor +
                ", college=" + college +
                '}';
    }

    public UserMessagepovo() {
    }

    public UserMessagepovo(Roal roal, TbAddress tbAddress, TbStudent tbStudent, TbClass tbClass, TbMajor tbMajor, College college) {
        this.roal = roal;
        this.tbAddress = tbAddress;
        this.tbStudent = tbStudent;
        this.tbClass = tbClass;
        this.tbMajor = tbMajor;
        this.college = college;
    }

    public Roal getRoal() {
        return roal;
    }

    public void setRoal(Roal roal) {
        this.roal = roal;
    }

    public TbAddress getTbAddress() {
        return tbAddress;
    }

    public void setTbAddress(TbAddress tbAddress) {
        this.tbAddress = tbAddress;
    }

    public TbStudent getTbStudent() {
        return tbStudent;
    }

    public void setTbStudent(TbStudent tbStudent) {
        this.tbStudent = tbStudent;
    }

    public TbClass getTbClass() {
        return tbClass;
    }

    public void setTbClass(TbClass tbClass) {
        this.tbClass = tbClass;
    }

    public TbMajor getTbMajor() {
        return tbMajor;
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
}
