package com.smartbean.service;


import com.smartbean.domain.Floor;
import com.smartbean.domain.FloorGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FloorGoodsService {
    public FloorGoods findOne(Long id);

    public FloorGoods saveOrUpdate(FloorGoods floorGoods);

    public Page<FloorGoods> findAll(FloorGoods floorGoods, Pageable pageable);

    public List<FloorGoods> findAll();

    public List<FloorGoods> findByFloorId(long floorId);
}
