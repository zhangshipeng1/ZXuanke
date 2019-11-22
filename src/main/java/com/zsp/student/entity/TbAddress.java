package com.zsp.student.entity;


import java.io.Serializable;

public class TbAddress implements Serializable {
  private static final long serialVersionID=1000012135L;
  private long addId;
  private String addProvince;
  private String addCity;
  private String addArea;

  public TbAddress() {
  }

  @Override
  public String toString() {
    return "TbAddress{" +
            "addId=" + addId +
            ", addProvince='" + addProvince + '\'' +
            ", addCity='" + addCity + '\'' +
            ", addArea='" + addArea + '\'' +
            '}';
  }

  public TbAddress(long addId, String addProvince, String addCity, String addArea) {

    this.addId = addId;
    this.addProvince = addProvince;
    this.addCity = addCity;
    this.addArea = addArea;
  }

  public long getAddId() {
    return addId;
  }

  public void setAddId(long addId) {
    this.addId = addId;
  }


  public String getAddProvince() {
    return addProvince;
  }

  public void setAddProvince(String addProvince) {
    this.addProvince = addProvince;
  }


  public String getAddCity() {
    return addCity;
  }

  public void setAddCity(String addCity) {
    this.addCity = addCity;
  }


  public String getAddArea() {
    return addArea;
  }

  public void setAddArea(String addArea) {
    this.addArea = addArea;
  }

}
