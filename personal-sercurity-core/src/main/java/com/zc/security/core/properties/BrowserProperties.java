package com.zc.security.core.properties;

/**
* @Description:    java类作用描述:浏览器模块配置管理类
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/28 0028 16:14
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/28 0028 16:14
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BrowserProperties {
    //登录页面
    private  String loginPage = "/defaultLogin.html";
    //登录类型 异步返回json，同步重定向
    private LoginType loginType= LoginType.JSON;
    //记住我的时间/单位秒
    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
