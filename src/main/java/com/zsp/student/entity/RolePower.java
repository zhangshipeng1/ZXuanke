package com.zsp.student.entity;


public class RolePower {

  private Integer rId;
  private Integer pId;


  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }

  public Integer getpId() {
    return pId;
  }

  public void setpId(Integer pId) {
    this.pId = pId;
  }

  public RolePower(Integer rId, Integer pId) {
    this.rId = rId;
    this.pId = pId;
  }

  public RolePower() {
  }

  @Override
  public String toString() {
    return "RolePower{" +
            "rId=" + rId +
            ", pId=" + pId +
            '}';
  }
}
