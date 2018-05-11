package com.smartbean.service.impl;

import com.google.common.collect.Lists;
import com.smartbean.domain.GoodsGallery;
import com.smartbean.domain.GoodsSpecification;
import com.smartbean.dto.GoodsSpecificationDTO;
import com.smartbean.repository.GoodsGalleryRepository;
import com.smartbean.repository.GoodsSpecificationRepository;
import com.smartbean.repository.SpecificationRepository;
import com.smartbean.service.GoodsGalleryService;
import com.smartbean.service.GoodsService;
import com.smartbean.service.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsSpecificationServiceImpl implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationRepository goodsSpecificationRepository;

    @Autowired
    private SpecificationRepository specificationRepository;

    @Override
    public GoodsSpecification findOne(Long id) {
        return goodsSpecificationRepository.getOne(id);
    }

    @Override
    public GoodsSpecification saveOrUpdate(GoodsSpecification goods) {
        return goodsSpecificationRepository.saveAndFlush(goods);
    }

    @Override
    public Page<GoodsSpecification> findAll(GoodsSpecification goodsSpecification, Pageable pageable) {
        return goodsSpecificationRepository.findAll(new Specification<GoodsSpecification>() {
            @Override
            public Predicate toPredicate(Root<GoodsSpecification> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<GoodsSpecification> findAll() {
        return goodsSpecificationRepository.findAll();
    }

    @Override
    public List<GoodsSpecificationDTO> findGoodsSpecification(long goodsId) {
        List<GoodsSpecification> goodsSpecifications = goodsSpecificationRepository.findByGoodsId(goodsId);
        List<Long> ids = Lists.newArrayList();
        List<GoodsSpecificationDTO> goodsSpecificationDTOS = Lists.newArrayList();

        for (GoodsSpecification goodsSpecification : goodsSpecifications){
            if (!ids.contains(goodsSpecification.getSpecificationId())){
                ids.add(goodsSpecification.getSpecificationId());

                GoodsSpecificationDTO goodsSpecificationDTO = new GoodsSpecificationDTO();
                goodsSpecificationDTO.setSpecification(specificationRepository.getOne(goodsSpecification.getSpecificationId()));
                goodsSpecificationDTOS.add(goodsSpecificationDTO);
            }
        }

        for (GoodsSpecificationDTO goodsSpecificationDTO : goodsSpecificationDTOS) {
            List<GoodsSpecification> goodsSpecifications1 = Lists.newArrayList();
            for (GoodsSpecification goodsSpecification : goodsSpecifications) {
                if (goodsSpecification.getSpecificationId() == goodsSpecificationDTO.getSpecification().getId()) {
                    goodsSpecifications1.add(goodsSpecification);
                }
            }
            goodsSpecificationDTO.setGoodsSpecifications(goodsSpecifications1);
        }
        return goodsSpecificationDTOS;
    }
}
