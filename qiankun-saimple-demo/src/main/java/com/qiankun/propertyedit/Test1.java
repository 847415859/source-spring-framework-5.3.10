package com.qiankun.propertyedit;

import com.qiankun.po.User;
import org.springframework.beans.SimpleTypeConverter;

/**
 * @Description:
 * @Date : 2023/12/05 17:45
 * @Auther : tiankun
 */
public class Test1 {
    public static void main(String[] args) {
        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        typeConverter.registerCustomEditor(User.class,new StringToUserPropertyEditor());

        User user = typeConverter.convertIfNecessary("1", User.class);
        System.out.println(user);
    }
}
