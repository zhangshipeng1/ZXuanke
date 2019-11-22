package com.zsp.student.entity;


import java.io.Serializable;

public class College implements Serializable {
  private static final long serialVersionID=100061661L;
  private Long collegeId;
  private String collegeName=null;

  @Override
  public String toString() {
    return "College{" +
            "collegeId=" + collegeId +
            ", collegeName='" + collegeName + '\'' +
            '}';
  }

  public Long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(Long collegeId) {
    this.collegeId = collegeId;
  }


  public String getCollegeName() {
    return collegeName;
  }

  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

}
