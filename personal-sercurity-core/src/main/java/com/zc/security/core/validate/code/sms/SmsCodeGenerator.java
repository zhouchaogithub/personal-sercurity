package com.zc.security.core.validate.code.sms;

import com.zc.security.core.properties.SecurityProperties;
import com.zc.security.core.validate.code.ValidateCode;
import com.zc.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
/**
* @Description:    java类作用描述：验证码生成器（默认短信验证码生成器）
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 15:36
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 15:36
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getCodeCount());
//        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getCodeCount());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
