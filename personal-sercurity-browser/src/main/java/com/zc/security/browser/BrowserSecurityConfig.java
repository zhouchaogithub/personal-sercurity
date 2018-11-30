package com.zc.security.browser;

import com.zc.security.browser.authentication.PersonalAuthenticationFailureHandler;
import com.zc.security.browser.authentication.PersonalAuthenticationSuccessHandler;
import com.zc.security.core.properties.SecurityProperties;
import com.zc.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
* @Description:    java类作用描述
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/28 0028 16:24
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/28 0028 16:24
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    //做登录时密码加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private PersonalAuthenticationSuccessHandler personalAuthenticationSeccessHander;

    @Autowired
    private PersonalAuthenticationFailureHandler personalAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //验证码的过滤器
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(personalAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) //将validateCodeFilter设置在UsernamePasswordAuthenticationFilter过滤器之前
            .formLogin()
            .loginPage("/authentication/require")
            .loginProcessingUrl("/authentication/form")
            .successHandler(personalAuthenticationSeccessHander)
            .failureHandler(personalAuthenticationFailureHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require"
            ,securityProperties.getBrowser().getLoginPage(),
                    "/code/image")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();//跨站请求伪造
    }
}
