package com.zsp.student.entity;

import java.io.Serializable;

/**
 * @Author：张世朋
 * @Date：Create in2019/17:19/2019/11/15
 * @logNmae：zsp
 * @DO:
 */
public class Huizong implements Serializable {
    private double sum;
    private double avg;
    private double gpa;

    @Override
    public String toString() {
        return "Huizong{" +
                "sum=" + sum +
                ", avg=" + avg +
                ", gpa=" + gpa +
                '}';
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Huizong() {
    }

    public Huizong(double sum, double avg, double gpa) {
        this.sum = sum;
        this.avg = avg;
        this.gpa = gpa;
    }
}
