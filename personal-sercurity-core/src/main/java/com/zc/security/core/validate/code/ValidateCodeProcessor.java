package com.zc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeProcessor {
    /**验证码放入session中的key的前缀*/
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE";

    /**
     * 创建校验码
     * ServletWebRequest 封装了请求和相应
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
    /**
    * 校验验证码
    * @author      zhouchaoit@sina.com
    * @param
    * @return
    * @exception
    * @date        2018/11/30 0030 16:22
    */
    void validate(ServletWebRequest servletWebRequest);
}
