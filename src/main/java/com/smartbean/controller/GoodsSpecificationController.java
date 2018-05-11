package com.smartbean.controller;


import com.alibaba.fastjson.JSONObject;
import com.smartbean.domain.GoodsGallery;
import com.smartbean.dto.GoodsSpecificationDTO;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.GoodsGalleryService;
import com.smartbean.service.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class GoodsSpecificationController {

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @RequestMapping("/api.goodsSpecification.list")
    public ResponseResult get(@RequestBody String param) {
        ResponseResult responseResult = new ResponseResult();
        JSONObject jsonObject = JSONObject.parseObject(param);
        long goodsId = jsonObject.getLong("goodsId");
        List<GoodsSpecificationDTO> goodsSpecificationDTOS = goodsSpecificationService.findGoodsSpecification(goodsId);
        responseResult.setResult(goodsSpecificationDTOS);
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}