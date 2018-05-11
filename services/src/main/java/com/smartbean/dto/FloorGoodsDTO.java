package com.smartbean.dto;

import com.smartbean.domain.Floor;
import com.smartbean.domain.Goods;

import java.io.Serializable;
import java.util.List;

public class FloorGoodsDTO implements Serializable{
    private Floor floor;
    private List<Goods> goods;

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
