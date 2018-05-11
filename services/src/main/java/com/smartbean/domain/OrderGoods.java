package com.smartbean.domain;


public class OrderGoods {

  private long id;
  private long orderId;
  private long goodsId;
  private String goodsName;
  private String goodsSn;
  private long productId;
  private long number;
  private double marketPrice;
  private double retailPrice;
  private String goodsSpecifitionNameValue;
  private long isReal;
  private String goodsSpecifitionIds;
  private String listPicUrl;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
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


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
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


  public String getGoodsSpecifitionNameValue() {
    return goodsSpecifitionNameValue;
  }

  public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
    this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
  }


  public long getIsReal() {
    return isReal;
  }

  public void setIsReal(long isReal) {
    this.isReal = isReal;
  }


  public String getGoodsSpecifitionIds() {
    return goodsSpecifitionIds;
  }

  public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
    this.goodsSpecifitionIds = goodsSpecifitionIds;
  }


  public String getListPicUrl() {
    return listPicUrl;
  }

  public void setListPicUrl(String listPicUrl) {
    this.listPicUrl = listPicUrl;
  }

}
