package com.zc.security.core.validate.code;

import com.zc.security.core.validate.code.image.ImageCode;
import com.zc.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/code")
public class ValidateCodeController {

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

     @GetMapping("/image")
    public void  createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG" ,response.getOutputStream());
     }
    @GetMapping("/sms")
    public void  createSMSCode(HttpServletRequest request, HttpServletResponse response) throws  ServletRequestBindingException {
         //获取验证码
         ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
         //将验证码放到session中
         sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,smsCode);
         //获取手机号
         String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
         //发送短信
         smsCodeSender.send(mobile,smsCode.getCode());
    }
}
