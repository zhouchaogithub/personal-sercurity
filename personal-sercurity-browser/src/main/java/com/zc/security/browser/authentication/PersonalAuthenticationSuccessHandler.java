package com.zc.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zc.security.core.properties.LoginType;
import com.zc.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class PersonalAuthenticationSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;


    /**
    * 方法实现说明
    * @author      zhouchaoit@sina.com
    * @param       authentication 封装了用户的认证信息
    * @return      
    * @exception   
    * @date        2018/11/28 0028 17:23
    */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
            logger.info("登录成功");
            //异步登录方式
            if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(authentication));
            }else {
              //同步登录方式
                super.onAuthenticationSuccess(request,response,authentication);
            }

    }
}
