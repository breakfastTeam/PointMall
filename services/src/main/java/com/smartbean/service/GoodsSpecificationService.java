package com.smartbean.service;


import com.smartbean.domain.GoodsGallery;
import com.smartbean.domain.GoodsSpecification;
import com.smartbean.dto.GoodsSpecificationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsSpecificationService {
    public GoodsSpecification findOne(Long id);

    public GoodsSpecification saveOrUpdate(GoodsSpecification goodsSpecification);

    public Page<GoodsSpecification> findAll(GoodsSpecification goodsSpecification, Pageable pageable);

    public List<GoodsSpecification> findAll();

    public List<GoodsSpecificationDTO> findGoodsSpecification(long goodsId);
}
