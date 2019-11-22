package com.zsp.student.entity;


import java.io.Serializable;

public class Time implements Serializable {
  private static final long serialVersionID=10007780L;
  private long timeId;
  private String timeCart;

  @Override
  public String toString() {
    return "Time{" +
            "timeId=" + timeId +
            ", timeCart='" + timeCart + '\'' +
            '}';
  }

  public long getTimeId() {
    return timeId;
  }

  public void setTimeId(long timeId) {
    this.timeId = timeId;
  }


  public String getTimeCart() {
    return timeCart;
  }

  public void setTimeCart(String timeCart) {
    this.timeCart = timeCart;
  }

}
