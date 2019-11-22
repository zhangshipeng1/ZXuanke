package com.zsp.student.entity;


import java.io.Serializable;

public class TbCourse implements Serializable {
  private static final long serialVersionID=100028177L;
  private long cId;
  private String cCnumber;
  private String cCname;
  private String cSort;
  private String cZhuanye;
  private String cMessage;
  private String cType;
  private String cXueyuan;
  private String cGrade;
  public String getcGrade() {
    return cGrade;
  }

  public void setcGrade(String cGrade) {
    this.cGrade = cGrade;
  }

  public TbCourse() {
  }

  public TbCourse(long cId, String cCnumber, String cCname, String cSort, String cZhuanye, String cMessage, String cType, String cXueyuan, String cGrade) {
    this.cId = cId;
    this.cCnumber = cCnumber;
    this.cCname = cCname;
    this.cSort = cSort;
    this.cZhuanye = cZhuanye;
    this.cMessage = cMessage;
    this.cType = cType;
    this.cXueyuan = cXueyuan;
    this.cGrade = cGrade;
  }

  @Override
  public String toString() {
    return "TbCourse{" +
            "cId=" + cId +
            ", cCnumber='" + cCnumber + '\'' +
            ", cCname='" + cCname + '\'' +
            ", cSort='" + cSort + '\'' +
            ", cZhuanye='" + cZhuanye + '\'' +
            ", cMessage='" + cMessage + '\'' +
            ", cType='" + cType + '\'' +
            ", cXueyuan='" + cXueyuan + '\'' +
            ", cGrade='" + cGrade + '\'' +
            '}';
  }

  public static long getSerialVersionID() {
    return serialVersionID;
  }

  public long getcId() {
    return cId;
  }

  public void setcId(long cId) {
    this.cId = cId;
  }

  public String getcCnumber() {
    return cCnumber;
  }

  public void setcCnumber(String cCnumber) {
    this.cCnumber = cCnumber;
  }

  public String getcCname() {
    return cCname;
  }

  public void setcCname(String cCname) {
    this.cCname = cCname;
  }

  public String getcSort() {
    return cSort;
  }

  public void setcSort(String cSort) {
    this.cSort = cSort;
  }

  public String getcZhuanye() {
    return cZhuanye;
  }

  public void setcZhuanye(String cZhuanye) {
    this.cZhuanye = cZhuanye;
  }

  public String getcMessage() {
    return cMessage;
  }

  public void setcMessage(String cMessage) {
    this.cMessage = cMessage;
  }

  public String getcType() {
    return cType;
  }

  public void setcType(String cType) {
    this.cType = cType;
  }

  public String getcXueyuan() {
    return cXueyuan;
  }

  public void setcXueyuan(String cXueyuan) {
    this.cXueyuan = cXueyuan;
  }
}
