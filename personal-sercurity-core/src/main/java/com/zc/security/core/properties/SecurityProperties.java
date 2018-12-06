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

    private BrowserProperties browser = new BrowserProperties();

    private ValidateProperties code = new ValidateProperties();

    private SocialProperties social = new SocialProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateProperties getCode() {
        return code;
    }

    public void setCode(ValidateProperties code) {
        this.code = code;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }
}