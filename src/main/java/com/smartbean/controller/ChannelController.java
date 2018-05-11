package com.smartbean.controller;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Channel;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.AdService;
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
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @RequestMapping("/api.channel.list")
    public ResponseResult list(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ResponseResult responseResult = new ResponseResult();
        Channel channel = new Channel();
        Page<Channel> channels = channelService.findAll(channel, pageable);
        responseResult.setResult(channels.getContent());
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}