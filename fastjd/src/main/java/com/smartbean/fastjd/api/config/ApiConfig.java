package com.smartbean.fastjd.api.config;

import com.smartbean.fastjd.api.response.GetJsApiTicketResponse;
import com.smartbean.fastjd.api.response.GetTokenResponse;
import com.smartbean.fastjd.exception.WeixinException;
import com.smartbean.fastjd.handle.ApiConfigChangeHandle;
import com.smartbean.fastjd.util.JSONUtil;
import com.smartbean.fastjd.util.NetWorkCenter;
import com.smartbean.fastjd.util.StrUtil;
import org.apache.http.HttpStatus;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * API配置类，项目中请保证其为单例
 * 实现观察者模式，用于监控token变化
 *
 * @author peiyu
 * @since 1.2
 */
public final class ApiConfig extends Observable implements Serializable {

    private static final Logger        LOG             = LoggerFactory.getLogger(ApiConfig.class);
    /**
     * 这里定义token正在刷新的标识，想要达到的目标是当有一个请求来获取token，发现token已经过期（我这里的过期逻辑是比官方提供的早100秒），然后开始刷新token
     * 在刷新的过程里，如果又继续来获取token，会先把旧的token返回，直到刷新结束，之后再来的请求，将获取到新的token
     * 利用AtomicBoolean实现原理：
     * 当请求来的时候，检查token是否已经过期（7100秒）以及标识是否已经是true（表示已经在刷新了，还没刷新完），过期则将此标识设为true，并开始刷新token
     * 在刷新结束前再次进来的请求，由于标识一直是true，而会直接拿到旧的token，由于我们的过期逻辑比官方的早100秒，所以旧的还可以继续用
     * 无论刷新token正在结束还是出现异常，都在最后将标识改回false，表示刷新工作已经结束
     */
    private final        AtomicBoolean tokenRefreshing = new AtomicBoolean(false);

    private final String  clientid;
    private final String  secret;
    private       String  accessToken;
    private       long    weixinTokenStartTime;
    private String username;
    private String password;
    private       String timestamp;
    private       String sign;


    /**
     * 构造方法一，实现同时获取access_token。不启用jsApi
     *
     * @param clientid  公众号clientid
     * @param secret 公众号secret
     */
    public ApiConfig(String clientid, String secret, String username, String password) {
        this.clientid = clientid;
        this.secret = secret;
        this.username = username;
        this.password = StrUtil.toMD5(password).toLowerCase();
        long now = System.currentTimeMillis();
        initToken(now);
    }


    public String getAppid() {
        return clientid;
    }

    public String getSecret() {
        return secret;
    }

    public String getAccessToken() {
        long now = System.currentTimeMillis();
        long time = now - this.weixinTokenStartTime;
        try {
            /*
             * 判断优先顺序：
             * 1.官方给出的超时时间是7200秒，这里用7100秒来做，防止出现已经过期的情况
             * 2.刷新标识判断，如果已经在刷新了，则也直接跳过，避免多次重复刷新，如果没有在刷新，则开始刷新
             */

            if (time > 7100000 && this.tokenRefreshing.compareAndSet(false, true)) {
                LOG.debug("准备刷新token.............");
                initToken(now);
            }
        } catch (Exception e) {
            LOG.warn("刷新Token出错.", e);
            //刷新工作出现有异常，将标识设置回false
            this.tokenRefreshing.set(false);
        }
        return accessToken;
    }


    /**
     * 添加配置变化监听器
     *
     * @param handle 监听器
     */
    public void addHandle(final ApiConfigChangeHandle handle) {
        super.addObserver(handle);
    }

    /**
     * 移除配置变化监听器
     *
     * @param handle 监听器
     */
    public void removeHandle(final ApiConfigChangeHandle handle) {
        super.deleteObserver(handle);
    }

    /**
     * 移除所有配置变化监听器
     */
    public void removeAllHandle() {
        super.deleteObservers();
    }

    /**
     * 初始化微信配置，即第一次获取access_token
     *
     * @param refreshTime 刷新时间
     */
    private void initToken(final long refreshTime) {
        LOG.debug("开始初始化access_token........");
        //记住原本的时间，用于出错回滚
        final long oldTime = this.weixinTokenStartTime;
        this.weixinTokenStartTime = refreshTime;
        refreshTimestamp();
        refreshSign();
        String url = "https://bizapi.jd.com/oauth2/accessToken?grant_type=access_token&client_id=" + this.clientid +
                "&client_secret=" + this.secret+"&timestamp=" + this.timestamp+"&username=" + this.username+"&password=" + this.password+"&sign=" + this.sign;
        NetWorkCenter.post(url, null, new NetWorkCenter.ResponseCallback() {
            @Override
            public void onResponse(int resultCode, String resultJson) {
                if (HttpStatus.SC_OK == resultCode) {
                    GetTokenResponse response = JSONUtil.toBean(resultJson, GetTokenResponse.class);
                    LOG.debug("获取access_token:{}", response.getAccessToken());
                    if (null == response.getAccessToken()) {
                        //刷新时间回滚
                        weixinTokenStartTime = oldTime;
                        throw new WeixinException("京东token获取出错，错误信息:" + response.getErrcode() + "," + response.getErrmsg());
                    }
                    accessToken = response.getAccessToken();
                    //设置通知点
                    setChanged();
                    notifyObservers(new ConfigChangeNotice(clientid, ChangeType.ACCESS_TOKEN, accessToken));
                }
            }
        });
        //刷新工作做完，将标识设置回false
        this.tokenRefreshing.set(false);
    }

    public void refreshTimestamp(){
//        this.timestamp = DateTime.now().toString("yyyy-MM-dd hh:mm:ss");
        this.timestamp = "2018-04-26 16:38:00";
    }

    public void refreshSign(){
        this.sign = StrUtil.toMD5(this.secret+this.timestamp+this.clientid+username+password+"access_token"+this.secret).toLowerCase();
    }

}
