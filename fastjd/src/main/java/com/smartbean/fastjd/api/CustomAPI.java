package com.smartbean.fastjd.api;

import com.smartbean.fastjd.api.config.ApiConfig;
import com.smartbean.fastjd.api.enums.ResultType;
import com.smartbean.fastjd.api.response.BaseResponse;
import com.smartbean.fastjd.message.BaseMsg;
import com.smartbean.fastjd.util.BeanUtil;
import com.smartbean.fastjd.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客服相关API
 *
 * @author peiyu
 * @since 1.2
 */
public class CustomAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(CustomAPI.class);

    public CustomAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 获取京东商品池编号
     *
     * @return 调用结果
     */
    public ResultType getPageNum() {
        LOG.debug("获取京东商品池编号......");
        String url = BASE_API_URL + "api/product/getPageNum?access_token=#";
        final Map<String, Object> params = new HashMap<String, Object>();

        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        return ResultType.get(response.getErrcode());
    }
}
