package com.qiankun.po;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Date : 2023/12/05 13:28
 * @Auther : tiankun
 */
@Service
public class User {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
