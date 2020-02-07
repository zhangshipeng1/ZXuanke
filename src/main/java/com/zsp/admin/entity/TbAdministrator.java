package com.zsp.admin.entity;


public class TbAdministrator {

  private long aId;
  private String aName;
  private String aIdcard;
  private String aPhone;
  private String aSex;
  private java.sql.Date aBirthday;
  private String aGongNumber;


  public long getAId() {
    return aId;
  }

  public void setAId(long aId) {
    this.aId = aId;
  }


  public String getAName() {
    return aName;
  }

  public void setAName(String aName) {
    this.aName = aName;
  }


  public String getAIdcard() {
    return aIdcard;
  }

  public void setAIdcard(String aIdcard) {
    this.aIdcard = aIdcard;
  }


  public String getAPhone() {
    return aPhone;
  }

  public void setAPhone(String aPhone) {
    this.aPhone = aPhone;
  }


  public String getASex() {
    return aSex;
  }

  public void setASex(String aSex) {
    this.aSex = aSex;
  }


  public java.sql.Date getABirthday() {
    return aBirthday;
  }

  public void setABirthday(java.sql.Date aBirthday) {
    this.aBirthday = aBirthday;
  }


  public String getAGongNumber() {
    return aGongNumber;
  }

  public void setAGongNumber(String aGongNumber) {
    this.aGongNumber = aGongNumber;
  }

}
