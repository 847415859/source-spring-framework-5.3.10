package com.qiankun.propertyedit;

import com.qiankun.po.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @Description:
 * @Date : 2023/12/05 13:28
 * @Auther : tiankun
 */
public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        user.setName(text);
        this.setValue(user);
    }
}
