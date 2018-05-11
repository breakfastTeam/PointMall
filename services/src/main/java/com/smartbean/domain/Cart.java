package com.smartbean.domain;


public class Cart {

  private long id;
  private long userId;
  private String sessionId;
  private long goodsId;
  private String goodsSn;
  private long productId;
  private String goodsName;
  private double marketPrice;
  private double retailPrice;
  private long number;
  private String goodsSpecifitionNameValue;
  private String goodsSpecifitionIds;
  private long checked;
  private String listPicUrl;


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


  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public String getGoodsSn() {
    return goodsSn;
  }

  public void setGoodsSn(String goodsSn) {
    this.goodsSn = goodsSn;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public double getMarketPrice() {
    return marketPrice;
  }

  public void setMarketPrice(double marketPrice) {
    this.marketPrice = marketPrice;
  }


  public double getRetailPrice() {
    return retailPrice;
  }

  public void setRetailPrice(double retailPrice) {
    this.retailPrice = retailPrice;
  }


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }


  public String getGoodsSpecifitionNameValue() {
    return goodsSpecifitionNameValue;
  }

  public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
    this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
  }


  public String getGoodsSpecifitionIds() {
    return goodsSpecifitionIds;
  }

  public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
    this.goodsSpecifitionIds = goodsSpecifitionIds;
  }


  public long getChecked() {
    return checked;
  }

  public void setChecked(long checked) {
    this.checked = checked;
  }


  public String getListPicUrl() {
    return listPicUrl;
  }

  public void setListPicUrl(String listPicUrl) {
    this.listPicUrl = listPicUrl;
  }

}
