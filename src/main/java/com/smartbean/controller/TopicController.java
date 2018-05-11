package com.smartbean.controller;


import com.smartbean.domain.Ad;
import com.smartbean.domain.Topic;
import com.smartbean.enums.ResponseResultEnum;
import com.smartbean.result.ResponseResult;
import com.smartbean.service.AdService;
import com.smartbean.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/api.topic.list")
    public ResponseResult list(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ResponseResult responseResult = new ResponseResult();
        Topic topic = new Topic();
        Page<Topic> topics = topicService.findAll(topic, pageable);
        responseResult.setResult(topics.getContent());
        responseResult.setErrorCode(ResponseResultEnum.OK.getDBValue());
        return responseResult;
    }
}