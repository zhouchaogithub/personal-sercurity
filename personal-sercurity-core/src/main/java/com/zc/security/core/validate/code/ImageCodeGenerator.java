package com.zc.security.core.validate.code;

import com.zc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
* @Description:    java类作用描述：验证码生成器（默认生成器）
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 10:57
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 10:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ImageCodeGenerator implements ValidateCodeGenerator {

    private SecurityProperties securityProperties;
    // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)
    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    @Override
    @SuppressWarnings("all")
    public ImageCode generate(ServletWebRequest request) {
        // 图片的宽度。
        int width = ServletRequestUtils.getIntParameter(request.getRequest(),
                "width",securityProperties.getCode().getImage().getWidth()) ;
        // 图片的高度。
        int height = ServletRequestUtils.getIntParameter(request.getRequest(),
                "height",securityProperties.getCode().getImage().getHeight());
        int fontHeight = 0;
        int red = 0, green = 0, blue = 0;
        // 验证码字符个数
        int codeCount = securityProperties.getCode().getImage().getCodeCount();
        // 验证码干扰线数
        int lineCount = securityProperties.getCode().getImage().getLineCount();
        int x = 0,  codeY = 0;

        x = width / (codeCount + 2);// 每个字符的宽度(左右各空出一个字符)
        fontHeight = height - 5;// 字体的高度
        codeY = height - 4;
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 生成随机数
        Random random = new Random();
        // 将图像填充为白色
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, width, height);
        // 创建字体,可以修改为其它的
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        g.setFont(font);

        for (int i = 0; i < lineCount; i++) {
            // 设置随机开始和结束坐标
            int xs = random.nextInt(width);// x坐标开始
            int ys = random.nextInt(height);// y坐标开始
            int xe = xs + random.nextInt(width / 8);// x坐标结束
            int ye = ys + random.nextInt(height / 8);// y坐标结束
            // 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。

            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }
        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        g.dispose();
        // 将四位数字的验证码保存到Session中。
        return new ImageCode(buffImg,randomCode.toString(),securityProperties.getCode().getImage().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
