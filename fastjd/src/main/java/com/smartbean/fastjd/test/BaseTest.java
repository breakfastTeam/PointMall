package com.smartbean.fastjd.test;

import com.smartbean.fastjd.api.CustomAPI;
import com.smartbean.fastjd.api.config.ApiConfig;
import com.smartbean.fastjd.api.enums.ResultType;
import jdk.nashorn.internal.scripts.JD;

public class BaseTest {

    private static String clientId = "3DA5qEFDyujYmDobcwlY";
    private static String clientSecret = "TdsIF4i6K7MCduGmVChW";

    public static void main(String args[]){
        JDConfig config = new JDConfig();
        CustomAPI customAPI = config.getCustomAPI(clientId, clientSecret);
        ResultType resultType = customAPI.getPageNum();
        System.out.println(resultType.toString());
    }
}
