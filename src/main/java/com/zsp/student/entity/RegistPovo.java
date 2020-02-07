package com.zsp.student.entity;

/**
 * @Author：张世朋
 * @Date：Create in2019/17:25/2019/12/28
 * @logNmae：zsp
 * @DO:
 */
public class RegistPovo {
    private String username;
    private String password;
    private String number;
    private String phoneNumber;
    private String email;
    private Long xueyuan;
    private Long zhuanye;
    private Long banji;

    @Override
    public String toString() {
        return "RegistPovo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", xueyuan=" + xueyuan +
                ", zhuanye=" + zhuanye +
                ", banji=" + banji +
                '}';
    }

    public RegistPovo() {
    }

    public RegistPovo(String username, String password, String number, String phoneNumber, String email, Long xueyuan, Long zhuanye, Long banji) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.xueyuan = xueyuan;
        this.zhuanye = zhuanye;
        this.banji = banji;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(Long xueyuan) {
        this.xueyuan = xueyuan;
    }

    public Long getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(Long zhuanye) {
        this.zhuanye = zhuanye;
    }

    public Long getBanji() {
        return banji;
    }

    public void setBanji(Long banji) {
        this.banji = banji;
    }
}
