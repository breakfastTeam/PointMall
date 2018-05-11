package com.smartbean.service.impl;

import com.google.common.collect.Lists;
import com.smartbean.domain.Ad;
import com.smartbean.domain.Category;
import com.smartbean.domain.Goods;
import com.smartbean.dto.CategoryGoodsDTO;
import com.smartbean.repository.AdRepository;
import com.smartbean.repository.CategoryRepository;
import com.smartbean.repository.GoodsRepository;
import com.smartbean.service.AdService;
import com.smartbean.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Category findOne(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Page<Category> findAll(Category category, Pageable pageable) {
        return categoryRepository.findAll(new Specification<Category>() {
            @Override
            public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(category.getName())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+category.getName()+"%"));
                }

                if(!StringUtils.isEmpty(category.getLevel())){
                    list.add(cb.equal(root.get("level").as(String.class), category.getLevel()));
                }

                if(!StringUtils.isEmpty(category.getParentId())){
                    list.add(cb.equal(root.get("parentId").as(Long.class), category.getParentId()));
                }

//                list.add(cb.between(root.get("endTime").as(Long.class), root.get("startTime").as(Long.class), System.currentTimeMillis()))
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryGoodsDTO> findAllCategoryAndGoods() {
        List<CategoryGoodsDTO> floorGoodsDTOS = Lists.newArrayList();
        List<Category> categories = categoryRepository.findByLevelOrderBySortOrderDesc("L1");
        for(Category category:categories){
            List<Goods> goods = goodsRepository.findTop6ByCategoryId(category.getId());
            CategoryGoodsDTO categoryGoodsDTO = new CategoryGoodsDTO();
            categoryGoodsDTO.setCategory(category);
            categoryGoodsDTO.setGoods(goods);
            floorGoodsDTOS.add(categoryGoodsDTO);
        }
        return floorGoodsDTOS;
    }
}
