package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/20:08/2019/11/3
 * @logNmae：zsp
 * @DO:
 */
public class IshasCcoursepovo extends  TbXuanke {
    private Time time;
    private TeacherCourse teacherCourse;

    public IshasCcoursepovo() {
    }

    public IshasCcoursepovo(Time time, TeacherCourse teacherCourse) {
        this.time = time;
        this.teacherCourse = teacherCourse;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TeacherCourse getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(TeacherCourse teacherCourse) {
        this.teacherCourse = teacherCourse;
    }
}
