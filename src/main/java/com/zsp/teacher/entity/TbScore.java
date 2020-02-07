package com.zsp.teacher.entity;


public class TbScore {

  private Long sId;
  private String sCourse;
  private Double sScore;
  private Long sXuefen;
  private String scId;

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

  public TbScore(Long sId, String sCourse, Double sScore, Long sXuefen, String scId) {
    this.sId = sId;
    this.sCourse = sCourse;
    this.sScore = sScore;
    this.sXuefen = sXuefen;
    this.scId = scId;
  }

  public Long getsId() {
    return sId;
  }

  public void setsId(Long sId) {
    this.sId = sId;
  }

  public String getsCourse() {
    return sCourse;
  }

  public void setsCourse(String sCourse) {
    this.sCourse = sCourse;
  }

  public Double getsScore() {
    return sScore;
  }

  public void setsScore(Double sScore) {
    this.sScore = sScore;
  }

  public Long getsXuefen() {
    return sXuefen;
  }

  public void setsXuefen(Long sXuefen) {
    this.sXuefen = sXuefen;
  }

  public String getScId() {
    return scId;
  }

  public void setScId(String scId) {
    this.scId = scId;
  }
}
