package com.zsp.student.entity;

import java.sql.Date;

/**
 * @Author：张世朋
 * @Date：Create in2019/19:46/2019/12/1
 * @logNmae：zsp
 * @DO:
 */
public class Frindpovo extends TbStudent{
    private long slId;
    private String slUsername;
    private String slPassword;
    private long slZhuanye;
    private long slXueyuan;
    private long slClass;
    private long sId;
    private String slImg;
    private String slNicheng;
    private String slXingqu;
    private String slPhone;
    private String slEmail;
    private String slPingjia;
    private long addId;
    private long tId;
    private long aId;
    private String xuanId;
    private Integer xuanCourse;
    private Integer xuanZhuangtai=0;
    private Integer xuanSlid;
    private Integer xuanTid;

    @Override
    public String toString() {
        return "Frindpovo{" +
                "slId=" + slId +
                ", slUsername='" + slUsername + '\'' +
                ", slPassword='" + slPassword + '\'' +
                ", slZhuanye=" + slZhuanye +
                ", slXueyuan=" + slXueyuan +
                ", slClass=" + slClass +
                ", sId=" + sId +
                ", slImg='" + slImg + '\'' +
                ", slNicheng='" + slNicheng + '\'' +
                ", slXingqu='" + slXingqu + '\'' +
                ", slPhone='" + slPhone + '\'' +
                ", slEmail='" + slEmail + '\'' +
                ", slPingjia='" + slPingjia + '\'' +
                ", addId=" + addId +
                ", tId=" + tId +
                ", aId=" + aId +
                ", xuanId='" + xuanId + '\'' +
                ", xuanCourse=" + xuanCourse +
                ", xuanZhuangtai=" + xuanZhuangtai +
                ", xuanSlid=" + xuanSlid +
                ", xuanTid=" + xuanTid +
                '}';
    }

    public Frindpovo() {
    }

    public Frindpovo(long slId, String slUsername, String slPassword, long slZhuanye, long slXueyuan, long slClass, long sId, String slImg, String slNicheng, String slXingqu, String slPhone, String slEmail, String slPingjia, long addId, long tId, long aId, String xuanId, Integer xuanCourse, Integer xuanZhuangtai, Integer xuanSlid, Integer xuanTid) {
        this.slId = slId;
        this.slUsername = slUsername;
        this.slPassword = slPassword;
        this.slZhuanye = slZhuanye;
        this.slXueyuan = slXueyuan;
        this.slClass = slClass;
        this.sId = sId;
        this.slImg = slImg;
        this.slNicheng = slNicheng;
        this.slXingqu = slXingqu;
        this.slPhone = slPhone;
        this.slEmail = slEmail;
        this.slPingjia = slPingjia;
        this.addId = addId;
        this.tId = tId;
        this.aId = aId;
        this.xuanId = xuanId;
        this.xuanCourse = xuanCourse;
        this.xuanZhuangtai = xuanZhuangtai;
        this.xuanSlid = xuanSlid;
        this.xuanTid = xuanTid;
    }

    public Frindpovo(Long sId, Long sNumber, String sName, Date sBirthday, Date sCreattime, String sIdcard, String sSex, String sAddress, String sPhonenumber, String sFathername, String sMonthername, String sFnumber, String sMnumber, long slId, String slUsername, String slPassword, long slZhuanye, long slXueyuan, long slClass, long sId1, String slImg, String slNicheng, String slXingqu, String slPhone, String slEmail, String slPingjia, long addId, long tId, long aId, String xuanId, Integer xuanCourse, Integer xuanZhuangtai, Integer xuanSlid, Integer xuanTid) {
        super(sId, sNumber, sName, sBirthday, sCreattime, sIdcard, sSex, sAddress, sPhonenumber, sFathername, sMonthername, sFnumber, sMnumber);
        this.slId = slId;
        this.slUsername = slUsername;
        this.slPassword = slPassword;
        this.slZhuanye = slZhuanye;
        this.slXueyuan = slXueyuan;
        this.slClass = slClass;
        this.sId = sId1;
        this.slImg = slImg;
        this.slNicheng = slNicheng;
        this.slXingqu = slXingqu;
        this.slPhone = slPhone;
        this.slEmail = slEmail;
        this.slPingjia = slPingjia;
        this.addId = addId;
        this.tId = tId;
        this.aId = aId;
        this.xuanId = xuanId;
        this.xuanCourse = xuanCourse;
        this.xuanZhuangtai = xuanZhuangtai;
        this.xuanSlid = xuanSlid;
        this.xuanTid = xuanTid;
    }

    public long getSlId() {
        return slId;
    }

    public void setSlId(long slId) {
        this.slId = slId;
    }

    public String getSlUsername() {
        return slUsername;
    }

    public void setSlUsername(String slUsername) {
        this.slUsername = slUsername;
    }

    public String getSlPassword() {
        return slPassword;
    }

    public void setSlPassword(String slPassword) {
        this.slPassword = slPassword;
    }

    public long getSlZhuanye() {
        return slZhuanye;
    }

    public void setSlZhuanye(long slZhuanye) {
        this.slZhuanye = slZhuanye;
    }

    public long getSlXueyuan() {
        return slXueyuan;
    }

    public void setSlXueyuan(long slXueyuan) {
        this.slXueyuan = slXueyuan;
    }

    public long getSlClass() {
        return slClass;
    }

    public void setSlClass(long slClass) {
        this.slClass = slClass;
    }

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }

    public String getSlImg() {
        return slImg;
    }

    public void setSlImg(String slImg) {
        this.slImg = slImg;
    }

    public String getSlNicheng() {
        return slNicheng;
    }

    public void setSlNicheng(String slNicheng) {
        this.slNicheng = slNicheng;
    }

    public String getSlXingqu() {
        return slXingqu;
    }

    public void setSlXingqu(String slXingqu) {
        this.slXingqu = slXingqu;
    }

    public String getSlPhone() {
        return slPhone;
    }

    public void setSlPhone(String slPhone) {
        this.slPhone = slPhone;
    }

    public String getSlEmail() {
        return slEmail;
    }

    public void setSlEmail(String slEmail) {
        this.slEmail = slEmail;
    }

    public String getSlPingjia() {
        return slPingjia;
    }

    public void setSlPingjia(String slPingjia) {
        this.slPingjia = slPingjia;
    }

    public long getAddId() {
        return addId;
    }

    public void setAddId(long addId) {
        this.addId = addId;
    }

    public long gettId() {
        return tId;
    }

    public void settId(long tId) {
        this.tId = tId;
    }

    public long getaId() {
        return aId;
    }

    public void setaId(long aId) {
        this.aId = aId;
    }

    public String getXuanId() {
        return xuanId;
    }

    public void setXuanId(String xuanId) {
        this.xuanId = xuanId;
    }

    public Integer getXuanCourse() {
        return xuanCourse;
    }

    public void setXuanCourse(Integer xuanCourse) {
        this.xuanCourse = xuanCourse;
    }

    public Integer getXuanZhuangtai() {
        return xuanZhuangtai;
    }

    public void setXuanZhuangtai(Integer xuanZhuangtai) {
        this.xuanZhuangtai = xuanZhuangtai;
    }

    public Integer getXuanSlid() {
        return xuanSlid;
    }

    public void setXuanSlid(Integer xuanSlid) {
        this.xuanSlid = xuanSlid;
    }

    public Integer getXuanTid() {
        return xuanTid;
    }

    public void setXuanTid(Integer xuanTid) {
        this.xuanTid = xuanTid;
    }
}
