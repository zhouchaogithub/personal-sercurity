package com.zc.security.core.social.qq.api;

import java.io.IOException;

/**
* @Description:    java类作用描述 : QQ的相关操作接口
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/12/5 0005 10:13
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/12/5 0005 10:13
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface QQ {
    /**
     * 获取QQ的用户信息
     * @return
     */
    QQUserInfo getUserInfo();
}
