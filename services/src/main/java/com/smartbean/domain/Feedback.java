package com.smartbean.domain;

public class Feedback {

  private long msgId;
  private long parentId;
  private long userId;
  private String userName;
  private String userEmail;
  private String msgTitle;
  private long msgType;
  private long msgStatus;
  private String msgContent;
  private long msgTime;
  private String messageImg;
  private long orderId;
  private long msgArea;


  public long getMsgId() {
    return msgId;
  }

  public void setMsgId(long msgId) {
    this.msgId = msgId;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getMsgTitle() {
    return msgTitle;
  }

  public void setMsgTitle(String msgTitle) {
    this.msgTitle = msgTitle;
  }


  public long getMsgType() {
    return msgType;
  }

  public void setMsgType(long msgType) {
    this.msgType = msgType;
  }


  public long getMsgStatus() {
    return msgStatus;
  }

  public void setMsgStatus(long msgStatus) {
    this.msgStatus = msgStatus;
  }


  public String getMsgContent() {
    return msgContent;
  }

  public void setMsgContent(String msgContent) {
    this.msgContent = msgContent;
  }


  public long getMsgTime() {
    return msgTime;
  }

  public void setMsgTime(long msgTime) {
    this.msgTime = msgTime;
  }


  public String getMessageImg() {
    return messageImg;
  }

  public void setMessageImg(String messageImg) {
    this.messageImg = messageImg;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getMsgArea() {
    return msgArea;
  }

  public void setMsgArea(long msgArea) {
    this.msgArea = msgArea;
  }

}
