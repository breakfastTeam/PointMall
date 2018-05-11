package com.smartbean.controller;


import com.smartbean.domain.Brand;
import com.smartbean.domain.Channel;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.BrandService;
import com.smartbean.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/api.brand.list")
    public ResponseResult list(@PageableDefault(value = 4, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ResponseResult responseResult = new ResponseResult();
        Brand brand = new Brand();
        Page<Brand> brands = brandService.findAll(brand, pageable);
        responseResult.setResult(brands.getContent());
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}