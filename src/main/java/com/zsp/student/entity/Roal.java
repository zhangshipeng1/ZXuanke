package com.zsp.student.entity;


import java.io.Serializable;

public class Roal implements Serializable {
  private static final long serialVersionID=1000093290L;
  private Integer rId;
  private String rName;

  public Roal(Integer rId) {
    this.rId = rId;
  }

  public Roal(Integer rId, String rName) {
    this.rId = rId;
    this.rName = rName;
  }

  public Roal() {
  }

  @Override
  public String toString() {
    return "Roal{" +
            "rId=" + rId +
            ", rName='" + rName + '\'' +
            '}';
  }

  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }

  public String getrName() {
    return rName;
  }

  public void setrName(String rName) {
    this.rName = rName;
  }
}
