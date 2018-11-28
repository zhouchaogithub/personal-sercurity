package com.zc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* @Description:    java类作用描述: springSecurity配置管理类/配置读取器
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/28 0028 16:24
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/28 0028 16:24
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@ConfigurationProperties(prefix = "personal.security")
public class SecurityProperties{
    //浏览器配置
    private BrowserProperties browserProperties = new BrowserProperties();

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}