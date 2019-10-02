package com.zsp.student.entity;

/**
 * @PackageName:com.zsp.student.entity
 * @ClassName:Coursespovo
 * @Description:
 * @Author 张世朋
 * @Data 2019/8/12 18:57
 */
public class Coursespovo extends TbCourse {
    private Time time;
    private TbMajor tbMajor;
    private TbTeacher tbTeacher;
    private  College college;
    private TeacherCourse teacherCourse;
    private String key;
    private TbXuanke tbXuanke;

    @Override
    public String toString() {
        return "Coursespovo{" +
                "time=" + time +
                ", tbMajor=" + tbMajor +
                ", tbTeacher=" + tbTeacher +
                ", college=" + college +
                ", teacherCourse=" + teacherCourse +
                ", key='" + key + '\'' +
                ", tbXuanke=" + tbXuanke +
                '}';
    }

    public TbXuanke getTbXuanke() {
        return tbXuanke;
    }

    public void setTbXuanke(TbXuanke tbXuanke) {
        this.tbXuanke = tbXuanke;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Coursespovo() {
    }

    public Coursespovo(Time time, TbMajor tbMajor, TbTeacher tbTeacher, College college, TeacherCourse teacherCourse, String key, TbXuanke tbXuanke) {
        this.time = time;
        this.tbMajor = tbMajor;
        this.tbTeacher = tbTeacher;
        this.college = college;
        this.teacherCourse = teacherCourse;
        this.key = key;
        this.tbXuanke = tbXuanke;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TbMajor getTbMajor() {
        return tbMajor;
    }

    public void setTbMajor(TbMajor tbMajor) {
        this.tbMajor = tbMajor;
    }

    public TbTeacher getTbTeacher() {
        return tbTeacher;
    }

    public void setTbTeacher(TbTeacher tbTeacher) {
        this.tbTeacher = tbTeacher;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public TeacherCourse getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(TeacherCourse teacherCourse) {
        this.teacherCourse = teacherCourse;
    }
}
