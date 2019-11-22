package com.zsp.student.entity;


import java.io.Serializable;

public class TbXuanke implements Serializable {
  private static final long serialVersionID=1000000L;
  private String xuanId;
  private Integer xuanCourse;
  private Integer xuanZhuangtai=0;
  private Integer xuanSlid;
  private Integer xuanTid;

    @Override
    public String toString() {
        return "TbXuanke{" +
                "xuanId='" + xuanId + '\'' +
                ", xuanCourse=" + xuanCourse +
                ", xuanZhuangtai=" + xuanZhuangtai +
                ", xuanSlid=" + xuanSlid +
                ", xuanTid=" + xuanTid +
                '}';
    }

    public TbXuanke() {
    }

    public TbXuanke(String xuanId, Integer xuanCourse, Integer xuanZhuangtai, Integer xuanSlid, Integer xuanTid) {
        this.xuanId = xuanId;
        this.xuanCourse = xuanCourse;
        this.xuanZhuangtai = xuanZhuangtai;
        this.xuanSlid = xuanSlid;
        this.xuanTid = xuanTid;
    }

    public String getXuanId() {
        return xuanId;
    }

    public void setXuanId(String xuanId) {
        this.xuanId = xuanId;
    }

    public Integer getXuanCourse() {
        return xuanCourse;
    }

    public void setXuanCourse(Integer xuanCourse) {
        this.xuanCourse = xuanCourse;
    }

    public Integer getXuanZhuangtai() {
        return xuanZhuangtai;
    }

    public void setXuanZhuangtai(Integer xuanZhuangtai) {
        this.xuanZhuangtai = xuanZhuangtai;
    }

    public Integer getXuanSlid() {
        return xuanSlid;
    }

    public void setXuanSlid(Integer xuanSlid) {
        this.xuanSlid = xuanSlid;
    }

    public Integer getXuanTid() {
        return xuanTid;
    }

    public void setXuanTid(Integer xuanTid) {
        this.xuanTid = xuanTid;
    }
}
