package com.demo.quickStart.web;

import com.demo.quickStart.conf.PropertiesValues;
import com.demo.quickStart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wsy on 2017/8/8.
 */
@RestController
public class UserController {
    @Autowired
    private PropertiesValues propertiesValues;

    @RequestMapping("getUser.do")
    public User getUser(){
        User user = new User();
        user.setName(propertiesValues.getUserName());
        user.setSex(1);
        return user;
    }
}
