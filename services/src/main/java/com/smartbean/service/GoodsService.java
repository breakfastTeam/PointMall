package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {
    public Goods findOne(Long id);

    public Goods saveOrUpdate(Goods goods);

    public Page<Goods> findAll(Goods goods, Pageable pageable);

    public List<Goods> findAll();

    public List<Goods> findTopSale6();

    public List<Goods> findNewArrival6();
}
