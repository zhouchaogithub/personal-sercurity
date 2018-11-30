package com.zc.security.core.validate.code.sms;
/**
* @Description:    java类作用描述：短信验证码发送器
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 15:04
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 15:04
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface SmsCodeSender {

    void send(String mobile,String code);

}
