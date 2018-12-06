package com.zc.security.core.social.qq.config;

import com.zc.security.core.properties.QQProperties;
import com.zc.security.core.properties.SecurityProperties;
import com.zc.security.core.social.qq.connect.QQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
* @Description:    java类作用描述:将QQ登录的相关配置属性配置到Social流程中
*                  @ConditionalOnProperty表示只有当系统中配置了QQ Social的配置项后QQ的连接工厂才生效，否则不生效
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/12/5 0005 13:57
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/12/5 0005 13:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
@ConditionalOnProperty(prefix = "personal.security.social.qq",name = "app-id")
public class QQAutoConfig  extends SocialAutoConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = securityProperties.getSocial().getQq();
        logger.info("providerId is :"+qqProperties.getProviderId());
        logger.info("appId is :"+qqProperties.getAppId());
        logger.info("appSecret is :"+qqProperties.getAppSecret());
        return new QQConnectionFactory(
                qqProperties.getProviderId(),
                qqProperties.getAppId(),
                qqProperties.getAppSecret());
    }
}
