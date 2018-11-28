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
* @Description:    java类作用描述
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/28 0028 16:15
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/28 0028 16:15
* @UpdateRemark:   修改内容
* @Version:        1.0
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
