package com.smartbean.service.impl;

import com.smartbean.domain.Ad;
import com.smartbean.domain.Topic;
import com.smartbean.repository.AdRepository;
import com.smartbean.repository.TopicRepository;
import com.smartbean.service.AdService;
import com.smartbean.service.TopicService;
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
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic findOne(Long id) {
        return topicRepository.getOne(id);
    }

    @Override
    public Topic saveOrUpdate(Topic topic) {
        return topicRepository.saveAndFlush(topic);
    }

    @Override
    public Page<Topic> findAll(Topic topic, Pageable pageable) {
        return topicRepository.findAll(new Specification<Topic>() {
            @Override
            public Predicate toPredicate(Root<Topic> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(topic.getTitle())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+topic.getTitle()+"%"));
                }

//                list.add(cb.between(root.get("endTime").as(Long.class), root.get("startTime").as(Long.class), System.currentTimeMillis()))
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
