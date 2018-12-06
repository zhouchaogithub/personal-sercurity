/**
 * 
 */
package com.zc.security.core.validate.code;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* @Description:    java类作用描述
* @Author:         zhouchaoit@sina.com
* @CreateDate:     2018/12/4 0004 11:00
* @UpdateUser:     zhouchaoit@sina.com
* @UpdateDate:     2018/12/4 0004 11:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Component
public class ValidateCodeProcessorHolder {

	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;

	public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}

	public ValidateCodeProcessor findValidateCodeProcessor(String type) {
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		ValidateCodeProcessor processor = validateCodeProcessors.get(name);
		if (processor == null) {
			throw new ValidateCodeException("验证码处理器" + name + "不存在");
		}
		return processor;
	}

}
