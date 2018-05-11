package com.smartbean.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_brand", uniqueConstraints = {})
public class Brand implements Serializable{

  private long id;
  private String name;
  private String listPicUrl;
  private String simpleDesc;
  private String picUrl;
  private long sortOrder;
  private long isShow;
  private double floorPrice;
  private String appListPicUrl;
  private long isNew;
  private String newPicUrl;
  private long newSortOrder;


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

  @Column(name = "list_pic_url")
  public String getListPicUrl() {
    return listPicUrl;
  }

  public void setListPicUrl(String listPicUrl) {
    this.listPicUrl = listPicUrl;
  }

  @Column(name = "simple_desc")
  public String getSimpleDesc() {
    return simpleDesc;
  }

  public void setSimpleDesc(String simpleDesc) {
    this.simpleDesc = simpleDesc;
  }

  @Column(name = "pic_url")
  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  @Column(name = "sort_order")
  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }

  @Column(name = "is_show")
  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }

  @Column(name = "floor_price")
  public double getFloorPrice() {
    return floorPrice;
  }

  public void setFloorPrice(double floorPrice) {
    this.floorPrice = floorPrice;
  }

  @Column(name = "app_list_pic_url")
  public String getAppListPicUrl() {
    return appListPicUrl;
  }

  public void setAppListPicUrl(String appListPicUrl) {
    this.appListPicUrl = appListPicUrl;
  }

  @Column(name = "is_new")
  public long getIsNew() {
    return isNew;
  }

  public void setIsNew(long isNew) {
    this.isNew = isNew;
  }

  @Column(name = "new_pic_url")
  public String getNewPicUrl() {
    return newPicUrl;
  }

  public void setNewPicUrl(String newPicUrl) {
    this.newPicUrl = newPicUrl;
  }

  @Column(name = "new_sort_order")
  public long getNewSortOrder() {
    return newSortOrder;
  }

  public void setNewSortOrder(long newSortOrder) {
    this.newSortOrder = newSortOrder;
  }

}
