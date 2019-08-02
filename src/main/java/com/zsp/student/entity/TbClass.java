package com.zsp.student.entity;


public class TbClass {

  private long classId;
  private String className;
  private long classRenshu;
  private long majorId;


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public long getClassRenshu() {
    return classRenshu;
  }

  public void setClassRenshu(long classRenshu) {
    this.classRenshu = classRenshu;
  }


  public long getMajorId() {
    return majorId;
  }

  public void setMajorId(long majorId) {
    this.majorId = majorId;
  }

}
