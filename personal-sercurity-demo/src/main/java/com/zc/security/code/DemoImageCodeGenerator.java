package com.zc.security.code;

import com.zc.security.core.properties.SecurityProperties;
import com.zc.security.core.validate.code.ImageCode;
import com.zc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
* @Description:    java类作用描述：更换默认验证码生成器
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 11:35
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 11:35
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("在此更换你需要的验证码生成器");
        return null;
    }
}
