package com.zsp.student.entity;


import java.io.Serializable;

public class TbMajor implements Serializable {
  private static final long serialVersionID=100123110L;
  private Long majorId;
  private String majorName=null;
  private Long collegeId;

  @Override
  public String toString() {
    return "TbMajor{" +
            "majorId=" + majorId +
            ", majorName='" + majorName + '\'' +
            ", collegeId=" + collegeId +
            '}';
  }

  public Long getMajorId() {
    return majorId;
  }

  public void setMajorId(Long majorId) {
    this.majorId = majorId;
  }


  public String getMajorName() {
    return majorName;
  }

  public void setMajorName(String majorName) {
    this.majorName = majorName;
  }


  public Long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(Long collegeId) {
    this.collegeId = collegeId;
  }

}
