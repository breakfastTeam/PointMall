package com.smartbean.service;


import com.smartbean.domain.Goods;
import com.smartbean.domain.GoodsGallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsGalleryService {
    public GoodsGallery findOne(Long id);

    public GoodsGallery saveOrUpdate(GoodsGallery goodsGallery);

    public Page<GoodsGallery> findAll(GoodsGallery goodsGallery, Pageable pageable);

    public List<GoodsGallery> findAll();

    public List<GoodsGallery> findGoodsGallery(long goodsId);
}
