package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_goods_gallery", uniqueConstraints = {})
public class GoodsGallery {

  private long id;
  private long goodsId;
  private String imgUrl;
  private String imgDesc;
  private long sortOrder;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "goods_id")
  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }

  @Column(name = "img_url")
  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  @Column(name = "img_desc")
  public String getImgDesc() {
    return imgDesc;
  }

  public void setImgDesc(String imgDesc) {
    this.imgDesc = imgDesc;
  }

  @Column(name = "sort_order")
  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }

}
