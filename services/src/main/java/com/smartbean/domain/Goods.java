package com.smartbean.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_goods", uniqueConstraints = {})
public class Goods implements Serializable {

  private long id;
  private long categoryId;
  private String goodsSn;
  private String name;
  private long brandId;
  private long goodsNumber;
  private String keywords;
  private String goodsBrief;
  private String goodsDesc;
  private long isOnSale;
  private long addTime;
  private long sortOrder;
  private long isDelete;
  private long attributeCategory;
  private double counterPrice;
  private double extraPrice;
  private long isNew;
  private String goodsUnit;
  private String primaryPicUrl;
  private String listPicUrl;
  private double retailPrice;
  private long sellVolume;
  private long primaryProductId;
  private double unitPrice;
  private String promotionDesc;
  private String promotionTag;
  private double appExclusivePrice;
  private long isAppExclusive;
  private long isLimited;
  private long isHot;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "category_id")
  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  @Column(name = "goods_sn")
  public String getGoodsSn() {
    return goodsSn;
  }

  public void setGoodsSn(String goodsSn) {
    this.goodsSn = goodsSn;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "brand_id")
  public long getBrandId() {
    return brandId;
  }

  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

  @Column(name = "goods_number")
  public long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }

  @Column(name = "keywords")
  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  @Column(name = "goods_brief")
  public String getGoodsBrief() {
    return goodsBrief;
  }

  public void setGoodsBrief(String goodsBrief) {
    this.goodsBrief = goodsBrief;
  }

  @Column(name = "goods_desc")
  public String getGoodsDesc() {
    return goodsDesc;
  }

  public void setGoodsDesc(String goodsDesc) {
    this.goodsDesc = goodsDesc;
  }

  @Column(name = "is_on_sale")
  public long getIsOnSale() {
    return isOnSale;
  }

  public void setIsOnSale(long isOnSale) {
    this.isOnSale = isOnSale;
  }

  @Column(name = "add_time")
  public long getAddTime() {
    return addTime;
  }

  public void setAddTime(long addTime) {
    this.addTime = addTime;
  }

  @Column(name = "sort_order")
  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }

  @Column(name = "is_delete")
  public long getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(long isDelete) {
    this.isDelete = isDelete;
  }

  @Column(name = "attribute_category")
  public long getAttributeCategory() {
    return attributeCategory;
  }

  public void setAttributeCategory(long attributeCategory) {
    this.attributeCategory = attributeCategory;
  }

  @Column(name = "counter_price")
  public double getCounterPrice() {
    return counterPrice;
  }

  public void setCounterPrice(double counterPrice) {
    this.counterPrice = counterPrice;
  }

  @Column(name = "extra_price")
  public double getExtraPrice() {
    return extraPrice;
  }

  public void setExtraPrice(double extraPrice) {
    this.extraPrice = extraPrice;
  }

  @Column(name = "is_new")
  public long getIsNew() {
    return isNew;
  }

  public void setIsNew(long isNew) {
    this.isNew = isNew;
  }

  @Column(name = "goods_unit")
  public String getGoodsUnit() {
    return goodsUnit;
  }

  public void setGoodsUnit(String goodsUnit) {
    this.goodsUnit = goodsUnit;
  }

  @Column(name = "primary_pic_url")
  public String getPrimaryPicUrl() {
    return primaryPicUrl;
  }

  public void setPrimaryPicUrl(String primaryPicUrl) {
    this.primaryPicUrl = primaryPicUrl;
  }

  @Column(name = "list_pic_url")
  public String getListPicUrl() {
    return listPicUrl;
  }

  public void setListPicUrl(String listPicUrl) {
    this.listPicUrl = listPicUrl;
  }

  @Column(name = "retail_price")
  public double getRetailPrice() {
    return retailPrice;
  }

  public void setRetailPrice(double retailPrice) {
    this.retailPrice = retailPrice;
  }

  @Column(name = "sell_volume")
  public long getSellVolume() {
    return sellVolume;
  }

  public void setSellVolume(long sellVolume) {
    this.sellVolume = sellVolume;
  }

  @Column(name = "primary_product_id")
  public long getPrimaryProductId() {
    return primaryProductId;
  }

  public void setPrimaryProductId(long primaryProductId) {
    this.primaryProductId = primaryProductId;
  }

  @Column(name = "unit_price")
  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Column(name = "promotion_desc")
  public String getPromotionDesc() {
    return promotionDesc;
  }

  public void setPromotionDesc(String promotionDesc) {
    this.promotionDesc = promotionDesc;
  }

  @Column(name = "promotion_tag")
  public String getPromotionTag() {
    return promotionTag;
  }

  public void setPromotionTag(String promotionTag) {
    this.promotionTag = promotionTag;
  }

  @Column(name = "app_exclusive_price")
  public double getAppExclusivePrice() {
    return appExclusivePrice;
  }

  public void setAppExclusivePrice(double appExclusivePrice) {
    this.appExclusivePrice = appExclusivePrice;
  }

  @Column(name = "is_app_exclusive")
  public long getIsAppExclusive() {
    return isAppExclusive;
  }

  public void setIsAppExclusive(long isAppExclusive) {
    this.isAppExclusive = isAppExclusive;
  }

  @Column(name = "is_limited")
  public long getIsLimited() {
    return isLimited;
  }

  public void setIsLimited(long isLimited) {
    this.isLimited = isLimited;
  }

  @Column(name = "is_hot")
  public long getIsHot() {
    return isHot;
  }

  public void setIsHot(long isHot) {
    this.isHot = isHot;
  }

}
