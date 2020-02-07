package com.zsp.student.entity;


public class TbPingjia {

  private String pingId;
  private Integer pingFenshu;
  private String pingPingyu;
  private String tId;
  private String sId;

  public TbPingjia() {
  }

  public TbPingjia(String pingId, Integer pingFenshu, String pingPingyu, String tId, String sId) {
    this.pingId = pingId;
    this.pingFenshu = pingFenshu;
    this.pingPingyu = pingPingyu;
    this.tId = tId;
    this.sId = sId;
  }

  public String getPingId() {
    return pingId;
  }

  public void setPingId(String pingId) {
    this.pingId = pingId;
  }


  public long getPingFenshu() {
    return pingFenshu;
  }

  public void setPingFenshu(Integer pingFenshu) {

    this.pingFenshu = pingFenshu;
  }

  public String getPingPingyu() {
    return pingPingyu;
  }

  public void setPingPingyu(String pingPingyu) {
    this.pingPingyu = pingPingyu;
  }


  public String getTId() {
    return tId;
  }

  public void setTId(String tId) {
    this.tId = tId;
  }


  public String getSId() {
    return sId;
  }

  public void setSId(String sId) {
    this.sId = sId;
  }

}
