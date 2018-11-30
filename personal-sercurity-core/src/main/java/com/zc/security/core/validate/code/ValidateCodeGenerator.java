package com.zc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;
/**
* @Description:    java类作用描述：验证码生成器
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 10:57
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 10:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface ValidateCodeGenerator {

     ImageCode generate(ServletWebRequest request);

}
