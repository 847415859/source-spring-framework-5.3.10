package com.qiankun.propertyedit;

import com.alibaba.fastjson2.JSON;
import com.qiankun.po.User;
import com.qiankun.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.Formatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @Description:
 * @Date : 2023/12/05 16:18
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        FormattingConversionService conversionService = new DefaultFormattingConversionService();
        //String -> ArrayList
        System.out.println(conversionService.convert("1,2,3,4", ArrayList.class));
        //boolean -> String
        System.out.println(conversionService.convert(true,String.class));
        //自定义了一个格式化器，User -> String ,String -> User
        conversionService.addFormatter(new Formatter<User>() {

            @Override
            public String print(User object, Locale locale) {
                return JSON.toJSONString(object);
            }

            @Override
            public User parse(String text, Locale locale) throws ParseException {
                return JSON.parseObject(text,User.class);
            }
        });
        User user = new User();
        user.setName("乾坤");
        String result = conversionService.convert(user, String.class);
        System.out.println(result);

        User userBak = conversionService.convert("{'name':'乾坤bak'}", User.class);
        System.out.println(userBak);
    }
}
