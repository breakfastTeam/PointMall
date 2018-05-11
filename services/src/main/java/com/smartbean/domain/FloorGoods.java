package com.smartbean.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_floor_goods", uniqueConstraints = {})
public class FloorGoods implements Serializable{
  private long id;
  private long floorId;
  private long goodsId;
  private long sortOrder;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "floor_id")
  public long getFloorId() {
    return floorId;
  }

  public void setFloorId(long floorId) {
    this.floorId = floorId;
  }

  @Column(name = "goods_id")
  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }

  @Column(name = "sort_order")
  public long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(long sortOrder) {
    this.sortOrder = sortOrder;
  }
}
