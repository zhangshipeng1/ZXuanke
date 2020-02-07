package com.zsp.teacher.entity;

import java.io.Serializable;

/**
 * @Author：张世朋
 * @Date：Create in2020/11:46/2020/2/1
 * @logNmae：zsp
 * @DO:
 */
public class Bingpovo implements Serializable {
    private static final long serialVersionID=198981661L;
    private String name;
    private String value;

    @Override
    public String toString() {
        return "Bingpovo{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Bingpovo() {
    }

    public Bingpovo(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
