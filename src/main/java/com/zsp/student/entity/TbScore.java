package com.zsp.student.entity;


import java.io.Serializable;

public class TbScore implements Serializable {
  private final  Long version=2131412l;
  private long sId;
  private String sCourse;
  private double sScore;
  private long sXuefen;
  private  String scId;

  @Override
  public String toString() {
    return "TbScore{" +
            "sId=" + sId +
            ", sCourse='" + sCourse + '\'' +
            ", sScore=" + sScore +
            ", sXuefen=" + sXuefen +
            ", scId='" + scId + '\'' +
            '}';
  }

  public TbScore() {
  }

  public TbScore(long sId, String sCourse, double sScore, long sXuefen, String scId) {
    this.sId = sId;
    this.sCourse = sCourse;
    this.sScore = sScore;
    this.sXuefen = sXuefen;
    this.scId = scId;
  }

  public String getScId() {
    return scId;
  }

  public void setScId(String scId) {
    this.scId = scId;
  }

  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getSCourse() {
    return sCourse;
  }

  public void setSCourse(String sCourse) {
    this.sCourse = sCourse;
  }


  public double getSScore() {
    return sScore;
  }

  public void setSScore(double sScore) {
    this.sScore = sScore;
  }


  public long getSXuefen() {
    return sXuefen;
  }

  public void setSXuefen(long sXuefen) {
    this.sXuefen = sXuefen;
  }

}
