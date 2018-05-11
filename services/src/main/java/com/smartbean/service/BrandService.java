package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    public Brand findOne(Long id);

    public Brand saveOrUpdate(Brand brand);

    public Page<Brand> findAll(Brand brand, Pageable pageable);

    public List<Brand> findAll();
}
