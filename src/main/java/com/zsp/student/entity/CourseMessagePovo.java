package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/8:47/2019/11/8
 * @logNmae：zsp
 * @DO:
 */
public class CourseMessagePovo extends TbCourse {
    private College college;
    private TbMajor tbMajor;

    @Override
    public String toString() {
        return "CourseMessagePovo{" +
                "college=" + college +
                ", tbMajor=" + tbMajor +
                '}';
    }

    public CourseMessagePovo() {
    }

    public CourseMessagePovo(long cId, String cCnumber, String cCname, String cSort, String cZhuanye, String cMessage, String cType, String cXueyuan, String cGrade) {
        super(cId, cCnumber, cCname, cSort, cZhuanye, cMessage, cType, cXueyuan, cGrade);
    }

    public CourseMessagePovo(College college, TbMajor tbMajor) {
        this.college = college;
        this.tbMajor = tbMajor;
    }

    public CourseMessagePovo(long cId, String cCnumber, String cCname, String cSort, String cZhuanye, String cMessage, String cType, String cXueyuan, String cGrade, College college, TbMajor tbMajor) {
        super(cId, cCnumber, cCname, cSort, cZhuanye, cMessage, cType, cXueyuan, cGrade);
        this.college = college;
        this.tbMajor = tbMajor;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public TbMajor getTbMajor() {
        return tbMajor;
    }

    public void setTbMajor(TbMajor tbMajor) {
        this.tbMajor = tbMajor;
    }
}
