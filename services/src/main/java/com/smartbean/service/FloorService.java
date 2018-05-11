package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Floor;
import com.smartbean.dto.FloorGoodsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FloorService {
    public Floor findOne(Long id);

    public Floor saveOrUpdate(Floor floor);

    public Page<Floor> findAll(Floor floor, Pageable pageable);

    public List<Floor> findAll();

    public List<FloorGoodsDTO> findAllFloorAndGoods();
}
