package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "nideshop_attribute", uniqueConstraints = {})
public class Attribute {

  private long id;
  private long attributeCategoryId;
  private String name;
  private long inputType;
  private String values;
  private long sortOrder;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "attribute_category_id")
  public long getAttributeCategoryId() {
    return attributeCategoryId;
  }

  public void setAttributeCategoryId(long attributeCategoryId) {
    this.attributeCategoryId = attributeCategoryId;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "input_type")
  public long getInputType() {
    return inputType;
  }

  public void setInputType(long inputType) {
    this.inputType = inputType;
  }

  @Column(name = "values")
  public String getValues() {
    return values;
  }

  public void setValues(String values) {
    this.values = values;
  }

  @Column(name = "sort_order")
  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }

}
