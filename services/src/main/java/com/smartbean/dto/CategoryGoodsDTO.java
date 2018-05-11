package com.smartbean.dto;

import com.smartbean.domain.Category;
import com.smartbean.domain.Floor;
import com.smartbean.domain.Goods;

import java.io.Serializable;
import java.util.List;

public class CategoryGoodsDTO implements Serializable{
    private Category category;
    private List<Goods> goods;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
