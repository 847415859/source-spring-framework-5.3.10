package com.qiankun.convert;

import org.springframework.core.convert.support.GenericConversionService;

/**
 * @Description:
 * @Date : 2024/07/08 9:25
 * @Auther : tiankun
 */
public class TestGeneraicConversionService {
    public static void main(String[] args) {
        GenericConversionService genericConversionService = new GenericConversionService();
        String convert = genericConversionService.convert(1, String.class);
    }
}
