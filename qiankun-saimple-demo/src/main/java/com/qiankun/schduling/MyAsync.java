package com.qiankun.schduling;

import java.lang.annotation.*;

/**
 * @Description:
 * @Date : 2024/06/28 10:24
 * @Auther : tiankun
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAsync {

    String value() default "";
}
