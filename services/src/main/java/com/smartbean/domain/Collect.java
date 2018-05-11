package com.smartbean.domain;


public class Collect {

  private long id;
  private long userId;
  private long valueId;
  private long addTime;
  private long isAttention;
  private long typeId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getValueId() {
    return valueId;
  }

  public void setValueId(long valueId) {
    this.valueId = valueId;
  }


  public long getAddTime() {
    return addTime;
  }

  public void setAddTime(long addTime) {
    this.addTime = addTime;
  }


  public long getIsAttention() {
    return isAttention;
  }

  public void setIsAttention(long isAttention) {
    this.isAttention = isAttention;
  }


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }

}
