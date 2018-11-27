package com.zc.security.browser;

import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhouchao
 * @Date: 2018/11/27 10:59
 * @Description:
 */
@Component
public class PersonalUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(PersonalUserDetailsService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       logger.info("login userName is " +username);
        //根据用户名查询用户信息
        if(!"张三".equals(username)){

        }
        logger.info("数据库密码是："+passwordEncoder.encode("123456"));
        return  new User(username,passwordEncoder.encode("123456"),true,
                true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
