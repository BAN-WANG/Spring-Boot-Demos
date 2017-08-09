package com.ss.quickStart.web;

import com.ss.quickStart.conf.PropertiesValues;
import com.ss.quickStart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

/**
 * Created by wsy on 2017/8/8.
 */
@RestController
public class UserController {
    @Autowired
    private PropertiesValues propertiesValues;

    //取配置文件中author.name值，若没有则赋值为ss
    @Value("${author.name:ss}")
    private String name;

    @RequestMapping("getUser.do")
    public User getUser(){
        User user = new User();
        user.setName(propertiesValues.getUserName());
        user.setSex(1);
        System.out.println(MessageFormat.format("name=>{0}",name));
        return user;
    }
}
