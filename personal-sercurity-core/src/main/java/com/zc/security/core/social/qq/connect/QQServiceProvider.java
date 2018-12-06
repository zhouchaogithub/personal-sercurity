package com.zc.security.core.social.qq.connect;

import com.zc.security.core.social.qq.api.QQ;
import com.zc.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private  String appId;

    private static final  String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final  String URL_ACCESSTOKENURL = "https://graph.qq.com/oauth2.0/token";

    //String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl
    public QQServiceProvider(String appId,String appSecret) {
        super(new OAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESSTOKENURL));
    }
    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }
}
