package com.qiankun.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Description:
 * @Date : 2023/12/09 10:13
 * @Auther : tiankun
 */
@Component
public class UserService extends BaseService<T1,T2>{

    //
    // @Value("${OS}")
    // public String java;
    //
    @Resource
    private User user;
    //
    //
    // public User getUser() {
    //     return user;
    // }
    //
    // public void setUser(User user) {
    //     this.user = user;
    // }

    public static void main(String[] args) throws NoSuchFieldException {
        Type genericSuperclass = UserService.class.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());

        TypeVariable<? extends Class<? super UserService>>[] typeParameters = UserService.class.getSuperclass().getTypeParameters();
        for (TypeVariable<? extends Class<? super UserService>> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName());
        }

    }

}
