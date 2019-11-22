package com.zsp.student.entity;


import java.io.Serializable;

public class TbClass implements Serializable {
  private static final long serialVersionID=10006666177L;
  private Long classId;
  private String className=null;
  private Long classRenshu;
  private Long majorId;


  public Long getClassId() {
    return classId;
  }

  public void setClassId(Long classId) {
    this.classId = classId;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public Long getClassRenshu() {
    return classRenshu;
  }

  public void setClassRenshu(Long classRenshu) {
    this.classRenshu = classRenshu;
  }


  public Long getMajorId() {
    return majorId;
  }

  public void setMajorId(Long majorId) {
    this.majorId = majorId;
  }

}
