package com.smartbean.service.impl;

import com.smartbean.domain.Floor;
import com.smartbean.domain.FloorGoods;
import com.smartbean.repository.FloorGoodsRepository;
import com.smartbean.repository.FloorRepository;
import com.smartbean.repository.GoodsRepository;
import com.smartbean.service.FloorGoodsService;
import com.smartbean.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class FloorGoodsServiceImpl implements FloorGoodsService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private FloorGoodsRepository floorGoodsRepository;

    @Autowired
    private GoodsRepository goodsRepository;




    @Override
    public FloorGoods findOne(Long id) {
        return floorGoodsRepository.getOne(id);
    }

    @Override
    public FloorGoods saveOrUpdate(FloorGoods floorGoods) {
        return floorGoodsRepository.saveAndFlush(floorGoods);
    }

    @Override
    public Page<FloorGoods> findAll(FloorGoods floorGoods, Pageable pageable) {
        return floorGoodsRepository.findAll(new Specification<FloorGoods>() {
            @Override
            public Predicate toPredicate(Root<FloorGoods> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<FloorGoods> findAll() {
        return floorGoodsRepository.findAll();
    }

    @Override
    public List<FloorGoods> findByFloorId(long floorId) {
        return floorGoodsRepository.findByFloorId(floorId);
    }
}
