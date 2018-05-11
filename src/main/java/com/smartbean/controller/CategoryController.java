package com.smartbean.controller;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Category;
import com.smartbean.dto.CategoryGoodsDTO;
import com.smartbean.enums.CategoryLevelEnum;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.AdService;
import com.smartbean.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/api.category.list")
    public ResponseResult greeting(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ResponseResult responseResult = new ResponseResult();
        Category category = new Category();
        category.setLevel(CategoryLevelEnum.LEVEL_ONE.getCode());
        Page<Category> categories = categoryService.findAll(category, pageable);
        responseResult.setResult(categories.getContent());
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }

    @RequestMapping("/api.categoryGoods.list")
    public ResponseResult categoryGoods(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ResponseResult responseResult = new ResponseResult();
        Category category = new Category();
        category.setLevel(CategoryLevelEnum.LEVEL_ONE.getCode());
        List<CategoryGoodsDTO> categories = categoryService.findAllCategoryAndGoods();
        responseResult.setResult(categories);
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}