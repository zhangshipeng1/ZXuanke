package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/22:49/2019/11/8
 * @logNmae：zsp
 * @DO:
 */
public class YiXuan extends TbXuanke {
    private  TbCourse tbCourse;

    public YiXuan() {
    }

    public YiXuan(TbCourse tbCourse) {
        this.tbCourse = tbCourse;
    }

    public YiXuan(String xuanId, Integer xuanCourse, Integer xuanZhuangtai, Integer xuanSlid, Integer xuanTid, TbCourse tbCourse) {
        super(xuanId, xuanCourse, xuanZhuangtai, xuanSlid, xuanTid);
        this.tbCourse = tbCourse;
    }

    public TbCourse getTbCourse() {
        return tbCourse;
    }

    public void setTbCourse(TbCourse tbCourse) {
        this.tbCourse = tbCourse;
    }
}
