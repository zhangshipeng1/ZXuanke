package com.zsp.student.entity;


import java.io.Serializable;

public class Power implements Serializable {
  private static final long serialVersionID=100023320L;
  private Integer pId;
  private String pName;
  private Integer pFtherid;
  private String pUrl;
  private String pHtml;
  private Integer pSort;
  private String pIcon;
  private String pType;
  private Integer pSpread;

  @Override
  public String toString() {
    return "Power{" +
            "pId=" + pId +
            ", pName='" + pName + '\'' +
            ", pFtherid=" + pFtherid +
            ", pUrl='" + pUrl + '\'' +
            ", pHtml='" + pHtml + '\'' +
            ", pSort=" + pSort +
            ", pIcon='" + pIcon + '\'' +
            ", pType='" + pType + '\'' +
            ", pSpread=" + pSpread +
            '}';
  }

  public Power() {
  }

  public Power(Integer pId, String pName, Integer pFtherid, String pUrl, String pHtml, Integer pSort, String pIcon, String pType, Integer pSpread) {
    this.pId = pId;
    this.pName = pName;
    this.pFtherid = pFtherid;
    this.pUrl = pUrl;
    this.pHtml = pHtml;
    this.pSort = pSort;
    this.pIcon = pIcon;
    this.pType = pType;
    this.pSpread = pSpread;
  }

  public Integer getpId() {
    return pId;
  }

  public void setpId(Integer pId) {
    this.pId = pId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public Integer getpFtherid() {
    return pFtherid;
  }

  public void setpFtherid(Integer pFtherid) {
    this.pFtherid = pFtherid;
  }

  public String getpUrl() {
    return pUrl;
  }

  public void setpUrl(String pUrl) {
    this.pUrl = pUrl;
  }

  public String getpHtml() {
    return pHtml;
  }

  public void setpHtml(String pHtml) {
    this.pHtml = pHtml;
  }

  public Integer getpSort() {
    return pSort;
  }

  public void setpSort(Integer pSort) {
    this.pSort = pSort;
  }

  public String getpIcon() {
    return pIcon;
  }

  public void setpIcon(String pIcon) {
    this.pIcon = pIcon;
  }

  public String getpType() {
    return pType;
  }

  public void setpType(String pType) {
    this.pType = pType;
  }

  public Integer getpSpread() {
    return pSpread;
  }

  public void setpSpread(Integer pSpread) {
    this.pSpread = pSpread;
  }
}
