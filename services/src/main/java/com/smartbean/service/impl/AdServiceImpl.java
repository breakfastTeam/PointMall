package com.smartbean.service.impl;

import com.smartbean.domain.Ad;
import com.smartbean.repository.AdRepository;
import com.smartbean.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Override
    public Ad findOne(Long id) {
        return adRepository.getOne(id);
    }

    @Override
    public Ad saveOrUpdate(Ad ad) {
        return adRepository.saveAndFlush(ad);
    }

    @Override
    public Page<Ad> findAll(Ad ad, Pageable pageable) {
        return adRepository.findAll(new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(ad.getName())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+ad.getName()+"%"));
                }

//                list.add(cb.between(root.get("endTime").as(Long.class), root.get("startTime").as(Long.class), System.currentTimeMillis()))
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Ad> findAll() {
        return adRepository.findAll();
    }
}
