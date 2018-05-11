package com.smartbean.service.impl;

import com.smartbean.domain.Ad;
import com.smartbean.domain.Channel;
import com.smartbean.repository.AdRepository;
import com.smartbean.repository.ChannelRepository;
import com.smartbean.service.AdService;
import com.smartbean.service.ChannelService;
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
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public Channel findOne(Long id) {
        return channelRepository.getOne(id);
    }

    @Override
    public Channel saveOrUpdate(Channel channel) {
        return channelRepository.saveAndFlush(channel);
    }

    @Override
    public Page<Channel> findAll(Channel channel, Pageable pageable) {
        return channelRepository.findAll(new Specification<Channel>() {
            @Override
            public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(channel.getName())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+channel.getName()+"%"));
                }

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }
}
