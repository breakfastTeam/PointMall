package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Category;
import com.smartbean.dto.CategoryGoodsDTO;
import com.smartbean.dto.FloorGoodsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    public Category findOne(Long id);

    public Category saveOrUpdate(Category category);

    public Page<Category> findAll(Category category, Pageable pageable);

    public List<Category> findAll();

    public List<CategoryGoodsDTO> findAllCategoryAndGoods();
}
