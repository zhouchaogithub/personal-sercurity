package com.zc.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
* @Description:    java类作用描述：图形验证码
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/29 0029 16:19
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/29 0029 16:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ValidateCode {

    private String code;
    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried(){
        return LocalDateTime.now().isAfter(expireTime);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
