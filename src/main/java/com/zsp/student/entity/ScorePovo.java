package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/19:16/2019/11/14
 * @logNmae：zsp
 * @DO:
 */
public class ScorePovo extends TbScore {
    private  TbStudent tbStudent;
    private  TbCourse tbCourse;
    private  College college;
    private  TbMajor tbMajor;

    public ScorePovo() {
    }

    public ScorePovo(long sId, String sCourse, double sScore, long sXuefen, String scId) {
        super(sId, sCourse, sScore, sXuefen, scId);
    }

    public ScorePovo(TbStudent tbStudent, TbCourse tbCourse, College college, TbMajor tbMajor) {
        this.tbStudent = tbStudent;
        this.tbCourse = tbCourse;
        this.college = college;
        this.tbMajor = tbMajor;
    }

    public ScorePovo(long sId, String sCourse, double sScore, long sXuefen, String scId, TbStudent tbStudent, TbCourse tbCourse, College college, TbMajor tbMajor) {
        super(sId, sCourse, sScore, sXuefen, scId);
        this.tbStudent = tbStudent;
        this.tbCourse = tbCourse;
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

    public TbStudent getTbStudent() {
        return tbStudent;
    }

    public void setTbStudent(TbStudent tbStudent) {
        this.tbStudent = tbStudent;
    }

    public TbCourse getTbCourse() {
        return tbCourse;
    }

    public void setTbCourse(TbCourse tbCourse) {
        this.tbCourse = tbCourse;
    }
}