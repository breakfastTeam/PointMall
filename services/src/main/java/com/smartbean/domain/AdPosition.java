package com.smartbean.domain;


public class AdPosition {

  private long id;
  private String name;
  private long width;
  private long height;
  private String desc;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getWidth() {
    return width;
  }

  public void setWidth(long width) {
    this.width = width;
  }


  public long getHeight() {
    return height;
  }

  public void setHeight(long height) {
    this.height = height;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

}
