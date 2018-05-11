package com.smartbean.domain;


public class RelatedGoods {

  private long id;
  private long goodsId;
  private long relatedGoodsId;


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


  public long getRelatedGoodsId() {
    return relatedGoodsId;
  }

  public void setRelatedGoodsId(long relatedGoodsId) {
    this.relatedGoodsId = relatedGoodsId;
  }

}
