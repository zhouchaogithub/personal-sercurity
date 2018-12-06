/**
 * 
 */
package com.zc.security.core.properties;
/**
* @Description:    java类作用描述 springsecurity的 配置接口
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 16:21
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 16:21
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface SecurityConstants {
	
	/**
	 * 默认的处理验证码的url前缀
	 */
	public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 * 
	 */
	public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
	/**
	 * 默认登录页面
	 * 
	 */
	public static final String DEFAULT_LOGIN_PAGE_URL = "/defaultLogin.html";
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * session失效默认的跳转地址
	 */
	public static final String DEFAULT_SESSION_INVALID_URL = "/session/invalid";

}
