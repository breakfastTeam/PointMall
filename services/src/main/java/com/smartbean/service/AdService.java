package com.smartbean.service;


import com.smartbean.domain.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdService {
    public Ad findOne(Long id);

    public Ad saveOrUpdate(Ad brand);

    public Page<Ad> findAll(Ad brand, Pageable pageable);

    public List<Ad> findAll();
}
