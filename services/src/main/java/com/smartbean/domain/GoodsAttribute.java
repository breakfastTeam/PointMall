package com.smartbean.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "nideshop_goods_attribute", uniqueConstraints = {})
public class GoodsAttribute {

  private long id;
  private long goodsId;
  private long attributeId;
  private String value;

  @Transient
  private Goods goods;

  @Transient
  private Attribute attribute;


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

  @Column(name = "attribute_id")
  public long getAttributeId() {
    return attributeId;
  }

  public void setAttributeId(long attributeId) {
    this.attributeId = attributeId;
  }

  @Column(name = "value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
  @JoinColumn(name = "attribute_id", referencedColumnName = "ID", insertable = false, updatable = false)
  @NotFound(action= NotFoundAction.IGNORE)
  public Attribute getAttribute() {
    return attribute;
  }

  public void setAttribute(Attribute attribute) {
    this.attribute = attribute;
  }

}
