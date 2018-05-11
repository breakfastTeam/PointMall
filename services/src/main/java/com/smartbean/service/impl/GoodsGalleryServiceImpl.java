package com.smartbean.service.impl;

import com.smartbean.domain.Goods;
import com.smartbean.domain.GoodsGallery;
import com.smartbean.repository.GoodsGalleryRepository;
import com.smartbean.repository.GoodsRepository;
import com.smartbean.service.GoodsGalleryService;
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
public class GoodsGalleryServiceImpl implements GoodsGalleryService {

    @Autowired
    private GoodsGalleryRepository goodsGalleryRepository;

    @Override
    public GoodsGallery findOne(Long id) {
        return goodsGalleryRepository.getOne(id);
    }

    @Override
    public GoodsGallery saveOrUpdate(GoodsGallery goods) {
        return goodsGalleryRepository.saveAndFlush(goods);
    }

    @Override
    public Page<GoodsGallery> findAll(GoodsGallery goodsGallery, Pageable pageable) {
        return goodsGalleryRepository.findAll(new Specification<GoodsGallery>() {
            @Override
            public Predicate toPredicate(Root<GoodsGallery> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<GoodsGallery> findAll() {
        return goodsGalleryRepository.findAll();
    }

    @Override
    public List<GoodsGallery> findGoodsGallery(long goodsId) {
        return goodsGalleryRepository.findByGoodsId(goodsId);
    }
}
