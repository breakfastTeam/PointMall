package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_category", uniqueConstraints = {})
public class Category {
  private long id;
  private String name;
  private String keywords;
  private String frontDesc;
  private long parentId;
  private long sortOrder;
  private long showIndex;
  private long isShow;
  private String bannerUrl;
  private String iconUrl;
  private String imgUrl;
  private String wapBannerUrl;
  private String level;
  private long type;
  private String frontName;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "keywords")
  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  @Column(name = "front_desc")
  public String getFrontDesc() {
    return frontDesc;
  }

  public void setFrontDesc(String frontDesc) {
    this.frontDesc = frontDesc;
  }

  @Column(name = "parent_id")
  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

  @Column(name = "sort_order")
  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }

  @Column(name = "show_index")
  public long getShowIndex() {
    return showIndex;
  }

  public void setShowIndex(long showIndex) {
    this.showIndex = showIndex;
  }

  @Column(name = "is_show")
  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }

  @Column(name = "banner_url")
  public String getBannerUrl() {
    return bannerUrl;
  }

  public void setBannerUrl(String bannerUrl) {
    this.bannerUrl = bannerUrl;
  }

  @Column(name = "icon_url")
  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  @Column(name = "img_url")
  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  @Column(name = "wap_banner_url")
  public String getWapBannerUrl() {
    return wapBannerUrl;
  }

  public void setWapBannerUrl(String wapBannerUrl) {
    this.wapBannerUrl = wapBannerUrl;
  }

  @Column(name = "level")
  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  @Column(name = "type")
  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }

  @Column(name = "front_name")
  public String getFrontName() {
    return frontName;
  }

  public void setFrontName(String frontName) {
    this.frontName = frontName;
  }

}
