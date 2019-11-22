package com.zsp.student.entity;


import java.io.Serializable;

public class TeacherCourse implements Serializable {
  private static final long serialVersionID=100002233L;
  private long tId;
  private long cId;
  private String tcTime;
  private long tcZhuangtai;
  private long tcRenshu;
  private String tcId;

  public String getTcId() {
    return tcId;
  }

  public TeacherCourse() {
  }

  @Override
  public String toString() {
    return "TeacherCourse{" +
            "tId=" + tId +
            ", cId=" + cId +
            ", tcTime='" + tcTime + '\'' +
            ", tcZhuangtai=" + tcZhuangtai +
            ", tcRenshu=" + tcRenshu +
            ", tcId='" + tcId + '\'' +
            '}';
  }

  public TeacherCourse(long tId, long cId, String tcTime, long tcZhuangtai, long tcRenshu, String tcId) {
    this.tId = tId;
    this.cId = cId;
    this.tcTime = tcTime;
    this.tcZhuangtai = tcZhuangtai;
    this.tcRenshu = tcRenshu;
    this.tcId = tcId;
  }

  public void setTcId(String tcId) {
    this.tcId = tcId;
  }

  public long getTcRenshu() {
    return tcRenshu;
  }

  public void setTcRenshu(long tcRenshu) {
    this.tcRenshu = tcRenshu;
  }



  public long getTId() {
    return tId;
  }

  public void setTId(long tId) {
    this.tId = tId;
  }


  public long getCId() {
    return cId;
  }

  public void setCId(long cId) {
    this.cId = cId;
  }


  public String getTcTime() {
    return tcTime;
  }

  public void setTcTime(String tcTime) {
    this.tcTime = tcTime;
  }


  public long getTcZhuangtai() {
    return tcZhuangtai;
  }

  public void setTcZhuangtai(long tcZhuangtai) {
    this.tcZhuangtai = tcZhuangtai;
  }

}
