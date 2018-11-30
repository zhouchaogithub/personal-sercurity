package com.zc.security.core.validate.code.image;

import com.zc.security.core.validate.code.ValidateCode;

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
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
