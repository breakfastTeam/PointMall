package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_topic", uniqueConstraints = {})
public class Topic {

  private long id;
  private String title;
  private String content;
  private String avatar;
  private String itemPicUrl;
  private String subtitle;
  private long topicCategoryId;
  private double priceInfo;
  private String readCount;
  private String scenePicUrl;
  private long topicTemplateId;
  private long topicTagId;
  private long sortOrder;
  private long isShow;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getItemPicUrl() {
    return itemPicUrl;
  }

  public void setItemPicUrl(String itemPicUrl) {
    this.itemPicUrl = itemPicUrl;
  }


  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }


  public long getTopicCategoryId() {
    return topicCategoryId;
  }

  public void setTopicCategoryId(long topicCategoryId) {
    this.topicCategoryId = topicCategoryId;
  }


  public double getPriceInfo() {
    return priceInfo;
  }

  public void setPriceInfo(double priceInfo) {
    this.priceInfo = priceInfo;
  }


  public String getReadCount() {
    return readCount;
  }

  public void setReadCount(String readCount) {
    this.readCount = readCount;
  }


  public String getScenePicUrl() {
    return scenePicUrl;
  }

  public void setScenePicUrl(String scenePicUrl) {
    this.scenePicUrl = scenePicUrl;
  }


  public long getTopicTemplateId() {
    return topicTemplateId;
  }

  public void setTopicTemplateId(long topicTemplateId) {
    this.topicTemplateId = topicTemplateId;
  }


  public long getTopicTagId() {
    return topicTagId;
  }

  public void setTopicTagId(long topicTagId) {
    this.topicTagId = topicTagId;
  }


  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }


  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }

}
