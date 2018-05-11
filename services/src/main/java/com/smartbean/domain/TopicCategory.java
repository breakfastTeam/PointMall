package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_topic_category", uniqueConstraints = {})
public class TopicCategory {

  private long id;
  private String title;
  private String picUrl;

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


  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

}
