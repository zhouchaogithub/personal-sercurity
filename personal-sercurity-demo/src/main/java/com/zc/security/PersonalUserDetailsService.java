package com.zc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
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
public class PersonalUserDetailsService implements UserDetailsService, SocialUserDetailsService {
    private Logger logger = LoggerFactory.getLogger(PersonalUserDetailsService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录/login userName is " +username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("social 登录:" +userId);
        return buildUser(userId);
    }
    private SocialUserDetails buildUser(String userId){
        logger.info("login user's Id is " +userId);
        logger.info("数据库密码是："+passwordEncoder.encode("123456"));
        return  new SocialUser(userId,passwordEncoder.encode("123456"),true,
                true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

    }
}
