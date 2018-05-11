package com.smartbean.domain;

public class UserCoupon {

  private long id;
  private long couponId;
  private String couponNumber;
  private long userId;
  private long usedTime;
  private long orderId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCouponId() {
    return couponId;
  }

  public void setCouponId(long couponId) {
    this.couponId = couponId;
  }


  public String getCouponNumber() {
    return couponNumber;
  }

  public void setCouponNumber(String couponNumber) {
    this.couponNumber = couponNumber;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getUsedTime() {
    return usedTime;
  }

  public void setUsedTime(long usedTime) {
    this.usedTime = usedTime;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

}
