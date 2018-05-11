package com.smartbean.fastjd.test;

import com.smartbean.fastjd.api.CustomAPI;
import com.smartbean.fastjd.api.config.ApiConfig;

public class JDConfig {
    public static ApiConfig apiConfig = null;
    private final String username = "壳牌喜力精英俱乐部";
    private final String password = "jd.com";
    public ApiConfig getApiConfig(String appId, String appSecret) {
        if (apiConfig == null) {
            apiConfig = new ApiConfig(appId, appSecret, username, password);
        }
        return apiConfig;
    }
    public CustomAPI getCustomAPI(String appId, String appSecret) {
        return new CustomAPI(this.getApiConfig(appId, appSecret));
    }
}
