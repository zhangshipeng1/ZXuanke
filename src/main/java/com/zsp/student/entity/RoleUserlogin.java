package com.zsp.student.entity;


import java.io.Serializable;

public class RoleUserlogin implements Serializable {
  private static final long serialVersionID=1000214140L;
  private long rId;
  private long slId;


  public long getRId() {
    return rId;
  }

  public void setRId(long rId) {
    this.rId = rId;
  }


  public long getSlId() {
    return slId;
  }

  public void setSlId(long slId) {
    this.slId = slId;
  }

}
