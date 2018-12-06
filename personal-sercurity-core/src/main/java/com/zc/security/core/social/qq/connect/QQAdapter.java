package com.zc.security.core.social.qq.connect;

import com.zc.security.core.social.qq.api.QQ;
import com.zc.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class QQAdapter implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues connectionValues) {
        QQUserInfo qqUserInfo = api.getUserInfo();
        connectionValues.setProviderUserId(String.valueOf(qqUserInfo.getOpenId()));
        connectionValues.setDisplayName(qqUserInfo.getNickname());
        connectionValues.setProfileUrl(null);
        connectionValues.setImageUrl(qqUserInfo.getFigureurl_qq_1());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String message) {

    }
}
