/**
 * 
 */
package com.zc.security.core.validate.code;

import com.zc.security.core.properties.SecurityConstants;

/**
* @Description:    java类作用描述：验证码的类型
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/11/30 0030 16:19
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/11/30 0030 16:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public enum ValidateCodeType {
	
	/**
	 * 短信验证码
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	},
	/**
	 * 图片验证码
	 */
	IMAGE {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
		}
	};

	/**
	 * 校验时从请求中获取的参数的名字
	 * @return
	 */
	public abstract String getParamNameOnValidate();

}
