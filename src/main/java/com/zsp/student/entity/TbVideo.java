package com.zsp.student.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class TbVideo implements Serializable {
  private final Long version=2131241214L;
  private String vId;
  private String vName;
  private String vJiename;
  private String vUrl;
  private String vTid;
  private java.sql.Timestamp vTime;
  private Integer vFz;
private  String vImg;

  @Override
  public String toString() {
    return "TbVideo{" +
            "version=" + version +
            ", vId='" + vId + '\'' +
            ", vName='" + vName + '\'' +
            ", vJiename='" + vJiename + '\'' +
            ", vUrl='" + vUrl + '\'' +
            ", vTid='" + vTid + '\'' +
            ", vTime=" + vTime +
            ", vFz=" + vFz +
            ", vImg='" + vImg + '\'' +
            '}';
  }

  public TbVideo() {
  }

  public TbVideo(String vId, String vName, String vJiename, String vUrl, String vTid, Timestamp vTime, Integer vFz, String vImg) {
    this.vId = vId;
    this.vName = vName;
    this.vJiename = vJiename;
    this.vUrl = vUrl;
    this.vTid = vTid;
    this.vTime = vTime;
    this.vFz = vFz;
    this.vImg = vImg;
  }

  public Long getVersion() {
    return version;
  }

  public String getvId() {
    return vId;
  }

  public void setvId(String vId) {
    this.vId = vId;
  }

  public String getvName() {
    return vName;
  }

  public void setvName(String vName) {
    this.vName = vName;
  }

  public String getvJiename() {
    return vJiename;
  }

  public void setvJiename(String vJiename) {
    this.vJiename = vJiename;
  }

  public String getvUrl() {
    return vUrl;
  }

  public void setvUrl(String vUrl) {
    this.vUrl = vUrl;
  }

  public String getvTid() {
    return vTid;
  }

  public void setvTid(String vTid) {
    this.vTid = vTid;
  }

  public Timestamp getvTime() {
    return vTime;
  }

  public void setvTime(Timestamp vTime) {
    this.vTime = vTime;
  }

  public Integer getvFz() {
    return vFz;
  }

  public void setvFz(Integer vFz) {
    this.vFz = vFz;
  }

  public String getvImg() {
    return vImg;
  }

  public void setvImg(String vImg) {
    this.vImg = vImg;
  }
}
