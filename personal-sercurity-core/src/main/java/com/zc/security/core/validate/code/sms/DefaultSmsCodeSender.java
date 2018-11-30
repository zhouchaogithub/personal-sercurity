package com.zc.security.core.validate.code.sms;

/**
* 方法实现说明
* @author      zhouchaoit@sina.com：默认短信发送器
* @param
* @return
* @exception
* @date        2018/11/30 0030 15:06
*/
public class DefaultSmsCodeSender  implements  SmsCodeSender{

    @Override
    public void send(String mobile, String code) {
        System.out.println("发送短信验证码，该短信验证码发送器需要具体应用提供，验证码是："+code);
    }
}
