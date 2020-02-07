package com.zsp.student.entity;

import java.sql.Date;

/**
 * @Author：张世朋
 * @Date：Create in2019/8:44/2019/12/7
 * @logNmae：zsp
 * @DO:
 */
public class VideoPovo extends TbVideo {
    private Integer tId;
    private String tGnumber;
    private String tName;
    private String tSex;
    private java.sql.Date tBir;
    private String tJibie;
    private String tPhone;
    private String tAddress;
    private String tPicture;
    private String tZu;
    private String tZzmm;
    private String tJingli;
    private String tXueli;
    private String tBiyeshool;
    private String tJiguan;
    private String tIdcard;

    @Override
    public String toString() {
        return "VideoPovo{" +
                "tId=" + tId +
                ", tGnumber='" + tGnumber + '\'' +
                ", tName='" + tName + '\'' +
                ", tSex='" + tSex + '\'' +
                ", tBir=" + tBir +
                ", tJibie='" + tJibie + '\'' +
                ", tPhone='" + tPhone + '\'' +
                ", tAddress='" + tAddress + '\'' +
                ", tPicture='" + tPicture + '\'' +
                ", tZu='" + tZu + '\'' +
                ", tZzmm='" + tZzmm + '\'' +
                ", tJingli='" + tJingli + '\'' +
                ", tXueli='" + tXueli + '\'' +
                ", tBiyeshool='" + tBiyeshool + '\'' +
                ", tJiguan='" + tJiguan + '\'' +
                ", tIdcard='" + tIdcard + '\'' +
                '}';
    }

    public VideoPovo() {
    }

    public VideoPovo(Integer tId, String tGnumber, String tName, String tSex, Date tBir, String tJibie, String tPhone, String tAddress, String tPicture, String tZu, String tZzmm, String tJingli, String tXueli, String tBiyeshool, String tJiguan, String tIdcard) {
        this.tId = tId;
        this.tGnumber = tGnumber;
        this.tName = tName;
        this.tSex = tSex;
        this.tBir = tBir;
        this.tJibie = tJibie;
        this.tPhone = tPhone;
        this.tAddress = tAddress;
        this.tPicture = tPicture;
        this.tZu = tZu;
        this.tZzmm = tZzmm;
        this.tJingli = tJingli;
        this.tXueli = tXueli;
        this.tBiyeshool = tBiyeshool;
        this.tJiguan = tJiguan;
        this.tIdcard = tIdcard;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettGnumber() {
        return tGnumber;
    }

    public void settGnumber(String tGnumber) {
        this.tGnumber = tGnumber;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public Date gettBir() {
        return tBir;
    }

    public void settBir(Date tBir) {
        this.tBir = tBir;
    }

    public String gettJibie() {
        return tJibie;
    }

    public void settJibie(String tJibie) {
        this.tJibie = tJibie;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public String gettPicture() {
        return tPicture;
    }

    public void settPicture(String tPicture) {
        this.tPicture = tPicture;
    }

    public String gettZu() {
        return tZu;
    }

    public void settZu(String tZu) {
        this.tZu = tZu;
    }

    public String gettZzmm() {
        return tZzmm;
    }

    public void settZzmm(String tZzmm) {
        this.tZzmm = tZzmm;
    }

    public String gettJingli() {
        return tJingli;
    }

    public void settJingli(String tJingli) {
        this.tJingli = tJingli;
    }

    public String gettXueli() {
        return tXueli;
    }

    public void settXueli(String tXueli) {
        this.tXueli = tXueli;
    }

    public String gettBiyeshool() {
        return tBiyeshool;
    }

    public void settBiyeshool(String tBiyeshool) {
        this.tBiyeshool = tBiyeshool;
    }

    public String gettJiguan() {
        return tJiguan;
    }

    public void settJiguan(String tJiguan) {
        this.tJiguan = tJiguan;
    }

    public String gettIdcard() {
        return tIdcard;
    }

    public void settIdcard(String tIdcard) {
        this.tIdcard = tIdcard;
    }
}
