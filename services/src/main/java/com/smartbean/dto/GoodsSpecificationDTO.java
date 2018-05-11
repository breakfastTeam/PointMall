package com.smartbean.dto;

import com.smartbean.domain.Floor;
import com.smartbean.domain.Goods;
import com.smartbean.domain.GoodsSpecification;
import com.smartbean.domain.Specification;

import java.io.Serializable;
import java.util.List;

public class GoodsSpecificationDTO implements Serializable{
    private Specification specification;
    private List<GoodsSpecification> goodsSpecifications;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<GoodsSpecification> getGoodsSpecifications() {
        return goodsSpecifications;
    }

    public void setGoodsSpecifications(List<GoodsSpecification> goodsSpecifications) {
        this.goodsSpecifications = goodsSpecifications;
    }
}
