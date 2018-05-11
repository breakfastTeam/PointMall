package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    public Topic findOne(Long id);

    public Topic saveOrUpdate(Topic topic);

    public Page<Topic> findAll(Topic topic, Pageable pageable);

    public List<Topic> findAll();
}
