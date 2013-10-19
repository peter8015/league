package com.league.notice.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * <p/>
 * SsBankMsgValidator which provides basic CRUD operations
 * 
 * @author Pan,Shaohua
 * @date 2013.10.09
 */
public class SsBankMsgValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(SsBankMsg.class);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "djgzName",
				"user.djgzName.required", "用户名不能为空");

		SsBankMsg ssBankMsg = (SsBankMsg) target;
		int length = ssBankMsg.getDjgzName().length();
		System.out.println("length**********:" + length);
		if (length > 1) {
			errors.rejectValue("djgzName", "user.djgzName.too_long",
					"用户名不能超过{20}个字符");
		}

	}
}
