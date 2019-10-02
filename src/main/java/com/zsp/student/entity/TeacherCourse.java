package com.zsp.student.entity;


public class TeacherCourse {

  private long tId;
  private long cId;
  private String tcTime;
  private long tcZhuangtai;


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
