package com.zsp.student.entity;


public class RoleStudentlogin {

  private Integer rId;
  private Integer slId;

  public RoleStudentlogin(Integer rId, Integer slId) {
    this.rId = rId;
    this.slId = slId;
  }

  @Override
  public String toString() {
    return "RoleStudentlogin{" +
            "rId=" + rId +
            ", slId=" + slId +
            '}';
  }

  public RoleStudentlogin() {
  }

  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }

  public Integer getSlId() {
    return slId;
  }

  public void setSlId(Integer slId) {
    this.slId = slId;
  }
}
