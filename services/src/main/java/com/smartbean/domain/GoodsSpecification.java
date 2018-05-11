package com.smartbean.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "t_goods_specification", uniqueConstraints = {})
public class GoodsSpecification {

  private long id;
  private long goodsId;
  private long specificationId;
  private String value;
  private String picUrl;

  @Transient
  private Goods goods;

  @Transient
  private Specification specification;

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

  @Column(name = "specification_id")
  public long getSpecificationId() {
    return specificationId;
  }

  public void setSpecificationId(long specificationId) {
    this.specificationId = specificationId;
  }

  @Column(name = "value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Column(name = "pic_url")
  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  @JoinColumn(name = "goods_id", referencedColumnName = "ID", insertable = false, updatable = false)
  @NotFound(action= NotFoundAction.IGNORE)
  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }

  @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  @JoinColumn(name = "specification_id", referencedColumnName = "ID", insertable = false, updatable = false)
  @NotFound(action= NotFoundAction.IGNORE)
  public Specification getSpecification() {
    return specification;
  }

  public void setSpecification(Specification specification) {
    this.specification = specification;
  }
}
