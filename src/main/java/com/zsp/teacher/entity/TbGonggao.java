package com.zsp.teacher.entity;


import java.sql.Timestamp;

public class TbGonggao implements Comparable<TbGonggao> {

  private String gId;
  private String gTitle;
  private String gMessage;
  private Timestamp gDate;

  public TbGonggao() {
  }

  public TbGonggao(String gId, String gTitle, String gMessage, Timestamp gDate) {
    this.gId = gId;
    this.gTitle = gTitle;
    this.gMessage = gMessage;
    this.gDate = gDate;
  }

  @Override
  public String toString() {
    return "TbGonggao{" +
            "gId='" + gId + '\'' +
            ", gTitle='" + gTitle + '\'' +
            ", gMessage='" + gMessage + '\'' +
            ", gDate=" + gDate +
            '}';
  }

  public String getGId() {
    return gId;
  }

  public void setGId(String gId) {
    this.gId = gId;
  }


  public String getGTitle() {
    return gTitle;
  }

  public void setGTitle(String gTitle) {
    this.gTitle = gTitle;
  }


  public String getGMessage() {
    return gMessage;
  }

  public void setGMessage(String gMessage) {
    this.gMessage = gMessage;
  }


  public java.sql.Timestamp getGDate() {
    return gDate;
  }

  public void setGDate(java.sql.Timestamp gDate) {
    this.gDate = gDate;
  }

  @Override
  public int compareTo(TbGonggao o) {
    if(o.getGDate().getTime()>this.getGDate().getTime()){
      return 1;
    }
    if(o.getGDate().getTime()==this.getGDate().getTime()){
     return 0;
    }
    if(o.getGDate().getTime()<this.getGDate().getTime()){
    return -1;
    }
    return 0;
  }
}
