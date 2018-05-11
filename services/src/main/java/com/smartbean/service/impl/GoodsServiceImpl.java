package com.smartbean.service.impl;

import com.smartbean.domain.Ad;
import com.smartbean.domain.Goods;
import com.smartbean.repository.AdRepository;
import com.smartbean.repository.GoodsRepository;
import com.smartbean.service.AdService;
import com.smartbean.service.GoodsService;
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
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods findOne(Long id) {
        return goodsRepository.getOne(id);
    }

    @Override
    public Goods saveOrUpdate(Goods goods) {
        return goodsRepository.saveAndFlush(goods);
    }

    @Override
    public Page<Goods> findAll(Goods goods, Pageable pageable) {
        return goodsRepository.findAll(new Specification<Goods>() {
            @Override
            public Predicate toPredicate(Root<Goods> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(goods.getName())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+goods.getName()+"%"));
                }

//                list.add(cb.between(root.get("endTime").as(Long.class), root.get("startTime").as(Long.class), System.currentTimeMillis()))
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> findTopSale6() {
        return goodsRepository.findTop6ByIsHot(1);
    }

    @Override
    public List<Goods> findNewArrival6() {
        return goodsRepository.findTop6ByIsNew(1);
    }
}
