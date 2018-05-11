package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ChannelService {
    public Channel findOne(Long id);

    public Channel saveOrUpdate(Channel channel);

    public Page<Channel> findAll(Channel channel, Pageable pageable);

    public List<Channel> findAll();
}
