package com.zsp.student.entity;


public class TbMajor {

  private Long majorId;
  private String majorName=null;
  private Long collegeId;


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
