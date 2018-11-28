package com.zc.security.browser.support;
/**
* @Description:    java类作用描述
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/28 0028 16:15
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/28 0028 16:15
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SimpleResponse {

    private Object content;

    public  SimpleResponse(Object content){
        this.content=content;
    }
    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
