package com.smartbean.service.impl;

import com.smartbean.domain.Ad;
import com.smartbean.domain.Brand;
import com.smartbean.repository.AdRepository;
import com.smartbean.repository.BrandRepository;
import com.smartbean.service.BrandService;
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
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand findOne(Long id) {
        return brandRepository.getOne(id);
    }

    @Override
    public Brand saveOrUpdate(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    @Override
    public Page<Brand> findAll(Brand brand, Pageable pageable) {
        return brandRepository.findAll(new Specification<Brand>() {
            @Override
            public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(brand.getName())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+brand.getName()+"%"));
                }

//                list.add(cb.between(root.get("endTime").as(Long.class), root.get("startTime").as(Long.class), System.currentTimeMillis()))
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
