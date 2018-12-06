package com.zc.security.browser;

import com.zc.security.core.authentication.AbstractChannelSecurityConfig;
import com.zc.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.zc.security.core.properties.SecurityConstants;
import com.zc.security.core.properties.SecurityProperties;
import com.zc.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

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
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SpringSocialConfigurer personalSocialSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      applyPasswordAuthenticationConfig(http);
        http.apply(validateCodeSecurityConfig)
                .and()
             .apply(smsCodeAuthenticationSecurityConfig)
                .and()
             .apply(personalSocialSecurityConfig)
                .and()
             .rememberMe()
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
             .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        securityProperties.getBrowser().getLoginPage()
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }


    //做登录时密码加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //记住我，读写数据库
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //tokenRepository.setCreateTableOnStartup(true);
        return  tokenRepository;
    }
}
