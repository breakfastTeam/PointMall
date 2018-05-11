package com.smartbean.controller;


import com.smartbean.domain.Ad;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class AuthController {

    @Autowired
    private AdService adService;

    @RequestMapping("/api.auth.signin")
    public ResponseResult signin(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ResponseResult responseResult = new ResponseResult();
//        Ad ad = new Ad();
//        Page<Ad> ads = adService.findAll(ad, pageable);
//        responseResult.setResult(ads.getContent());
//        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}