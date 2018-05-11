package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "nideshop_attribute_category", uniqueConstraints = {})
public class AttributeCategory {

  private long id;
  private String name;
  private long enabled;

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

  @Column(name = "enabled")
  public long getEnabled() {
    return enabled;
  }

  public void setEnabled(long enabled) {
    this.enabled = enabled;
  }

}
