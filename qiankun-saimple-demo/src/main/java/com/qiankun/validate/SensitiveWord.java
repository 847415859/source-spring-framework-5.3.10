package com.qiankun.validate;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { SensitiveWordValidator.class })
public @interface SensitiveWord {

    //默认错误消息
    String message() default "文本中存在敏感词";

    //分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};
}