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

    private  String loginPage = "/defaultLogin.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
