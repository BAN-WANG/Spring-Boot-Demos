package com.demo.quickStart.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wsy on 2017/8/8.
 */
@Component
public class PropertiesValues {
    @Value("${author.name}")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
