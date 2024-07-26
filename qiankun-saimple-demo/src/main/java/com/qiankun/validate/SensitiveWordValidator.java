package com.qiankun.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description:
 * @Date : 2024/07/09 7:49
 * @Auther : tiankun
 */
public class SensitiveWordValidator implements ConstraintValidator<SensitiveWord, String> {

    @Override
    public void initialize(SensitiveWord constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        // 加载敏感词库
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
