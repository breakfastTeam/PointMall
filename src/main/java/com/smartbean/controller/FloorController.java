package com.smartbean.controller;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Floor;
import com.smartbean.dto.FloorGoodsDTO;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.AdService;
import com.smartbean.service.FloorService;
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
public class FloorController {

    @Autowired
    private FloorService floorService;

    @RequestMapping("/api.floorAndGoods.list")
    public ResponseResult floors() {
        ResponseResult responseResult = new ResponseResult();
        List<FloorGoodsDTO> floorGoodsDTOS = floorService.findAllFloorAndGoods();
        responseResult.setResult(floorGoodsDTOS);
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}