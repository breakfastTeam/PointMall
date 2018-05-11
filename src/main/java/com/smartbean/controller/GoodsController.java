package com.smartbean.controller;


import com.smartbean.domain.Goods;
import com.smartbean.dto.FloorGoodsDTO;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.FloorService;
import com.smartbean.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/api.goods.topSaleList")
    public ResponseResult topSaleList() {
        ResponseResult responseResult = new ResponseResult();
        List<Goods> goods = goodsService.findTopSale6();
        responseResult.setResult(goods);
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }

    @RequestMapping("/api.goods.newArrivalList")
    public ResponseResult newArrivalList() {
        ResponseResult responseResult = new ResponseResult();
        List<Goods> goods = goodsService.findNewArrival6();
        responseResult.setResult(goods);
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }


    @RequestMapping("/api.goods.get")
    public ResponseResult get(@RequestBody String param) {
        ResponseResult responseResult = new ResponseResult();
        JSONObject jsonObject = JSONObject.parseObject(param);
        long goodsId = jsonObject.getLong("goodsId");
        Goods goods = goodsService.findOne(goodsId);
        responseResult.setResult(goods);
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}