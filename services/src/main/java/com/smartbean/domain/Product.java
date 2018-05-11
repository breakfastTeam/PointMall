package com.smartbean.domain;


public class Product {

  private long id;
  private long goodsId;
  private String goodsSpecificationIds;
  private String goodsSn;
  private long goodsNumber;
  private double retailPrice;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public String getGoodsSpecificationIds() {
    return goodsSpecificationIds;
  }

  public void setGoodsSpecificationIds(String goodsSpecificationIds) {
    this.goodsSpecificationIds = goodsSpecificationIds;
  }


  public String getGoodsSn() {
    return goodsSn;
  }

  public void setGoodsSn(String goodsSn) {
    this.goodsSn = goodsSn;
  }


  public long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }


  public double getRetailPrice() {
    return retailPrice;
  }

  public void setRetailPrice(double retailPrice) {
    this.retailPrice = retailPrice;
  }

}
