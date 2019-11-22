package com.zsp.student.entity;


import java.io.Serializable;
import java.sql.Date;

public class TbStudent implements Serializable {
  private static final long serialVersionID=100012123L;
  private Long sId;
  private Long sNumber;
  private String sName;
  private Date sBirthday;
  private Date sCreattime;
  private String sIdcard;
  private String sSex;
  private String sAddress;
  private String sPhonenumber;
  private String sFathername;
  private String sMonthername;
  private String sFnumber;
  private String sMnumber;

  @Override
  public String
  toString() {
    return "TbStudent{" +
            "sId=" + sId +
            ", sNumber=" + sNumber +
            ", sName='" + sName + '\'' +
            ", sBirthday=" + sBirthday +
            ", sCreattime=" + sCreattime +
            ", sIdcard='" + sIdcard + '\'' +
            ", sSex='" + sSex + '\'' +
            ", sAddress='" + sAddress + '\'' +
            ", sPhonenumber='" + sPhonenumber + '\'' +
            ", sFathername='" + sFathername + '\'' +
            ", sMonthername='" + sMonthername + '\'' +
            ", sFnumber='" + sFnumber + '\'' +
            ", sMnumber='" + sMnumber + '\'' +
            '}';
  }

  public TbStudent() {
  }

  public TbStudent(Long sId, Long sNumber, String sName, Date sBirthday, Date sCreattime, String sIdcard, String sSex, String sAddress, String sPhonenumber, String sFathername, String sMonthername, String sFnumber, String sMnumber) {
    this.sId = sId;
    this.sNumber = sNumber;
    this.sName = sName;
    this.sBirthday = sBirthday;
    this.sCreattime = sCreattime;
    this.sIdcard = sIdcard;
    this.sSex = sSex;
    this.sAddress = sAddress;
    this.sPhonenumber = sPhonenumber;
    this.sFathername = sFathername;
    this.sMonthername = sMonthername;
    this.sFnumber = sFnumber;
    this.sMnumber = sMnumber;
  }

  public Long getSId() {
    return sId;
  }

  public void setSId(Long sId) {
    this.sId = sId;
  }


  public Long getSNumber() {
    return sNumber;
  }

  public void setSNumber(Long sNumber) {
    this.sNumber = sNumber;
  }


  public String getSName() {
    return sName;
  }

  public void setSName(String sName) {
    this.sName = sName;
  }


  public Date getSBirthday() {
    return sBirthday;
  }

  public void setSBirthday(java.sql.Date sBirthday) {
    this.sBirthday = sBirthday;
  }


  public Date getSCreattime() {
    return sCreattime;
  }

  public void setSCreattime(java.sql.Date sCreattime) {
    this.sCreattime = sCreattime;
  }


  public String getSIdcard() {
    return sIdcard;
  }

  public void setSIdcard(String sIdcard) {
    this.sIdcard = sIdcard;
  }


  public String getSSex() {
    return sSex;
  }

  public void setSSex(String sSex) {
    this.sSex = sSex;
  }


  public String getSAddress() {
    return sAddress;
  }

  public void setSAddress(String sAddress) {
    this.sAddress = sAddress;
  }


  public String getSPhonenumber() {
    return sPhonenumber;
  }

  public void setSPhonenumber(String sPhonenumber) {
    this.sPhonenumber = sPhonenumber;
  }


  public String getSFathername() {
    return sFathername;
  }

  public void setSFathername(String sFathername) {
    this.sFathername = sFathername;
  }


  public String getSMonthername() {
    return sMonthername;
  }

  public void setSMonthername(String sMonthername) {
    this.sMonthername = sMonthername;
  }


  public String getSFnumber() {
    return sFnumber;
  }

  public void setSFnumber(String sFnumber) {
    this.sFnumber = sFnumber;
  }


  public String getSMnumber() {
    return sMnumber;
  }

  public void setSMnumber(String sMnumber) {
    this.sMnumber = sMnumber;
  }

}
