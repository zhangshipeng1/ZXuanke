package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/9:37/2019/12/11
 * @logNmae：zsp
 * @DO:
 */
public class PingjiaPovo extends TbPingjia {
    private String tName;
    private String sUsername;
    private String tCourese;

    @Override
    public String toString() {
        return "PingjiaPovo{" +
                "tName='" + tName + '\'' +
                ", sUsername='" + sUsername + '\'' +
                ", tCourese='" + tCourese + '\'' +
                '}';
    }

    public PingjiaPovo() {
    }

    public String gettCourese() {
        return tCourese;
    }

    public void settCourese(String tCourese) {
        this.tCourese = tCourese;
    }

    public PingjiaPovo(String tName, String sUsername, String tCourese) {
        this.tName = tName;
        this.sUsername = sUsername;
        this.tCourese = tCourese;
    }

    public PingjiaPovo(String pingId, Integer pingFenshu, String pingPingyu, String tId, String sId, String tName, String sUsername, String tCourese) {
        super(pingId, pingFenshu, pingPingyu, tId, sId);
        this.tName = tName;
        this.sUsername = sUsername;
        this.tCourese = tCourese;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }
}
