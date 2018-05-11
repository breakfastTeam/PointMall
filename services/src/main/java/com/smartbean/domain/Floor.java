package com.smartbean.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_floor", uniqueConstraints = {})
public class Floor implements Serializable {
  private long id;
  private String name;
  private long sortOrder;
  private String imageUrl;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
