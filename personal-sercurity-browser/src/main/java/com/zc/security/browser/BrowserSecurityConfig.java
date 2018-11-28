package com.zc.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/authentication/require")
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require").permitAll()
            .anyRequest()
            .authenticated();
    }
}
