package com.zsp.teacher.entity;

import java.io.Serializable;

/**
 * @Author：张世朋
 * @Date：Create in2020/10:30/2020/2/1
 * @logNmae：zsp
 * @DO:
 */
public class XuankethMesspovo implements Serializable {
    private static final long serialVersionID=10015560L;
    private String sNumber;
    private String sName;
    private String cCname;
    private String collegeName;
    private String majorName;
    private String className;

    @Override
    public String toString() {
        return "XuankethMesspovo{" +
                "sNumber=" + sNumber +
                ", sName='" + sName + '\'' +
                ", cCname='" + cCname + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public XuankethMesspovo() {
    }

    public XuankethMesspovo(String sNumber, String sName, String cCname, String collegeName, String majorName, String className) {
        this.sNumber = sNumber;
        this.sName = sName;
        this.cCname = cCname;
        this.collegeName = collegeName;
        this.majorName = majorName;
        this.className = className;
    }

    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getcCname() {
        return cCname;
    }

    public void setcCname(String cCname) {
        this.cCname = cCname;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
