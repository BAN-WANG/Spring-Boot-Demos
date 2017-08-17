package com.ss.quickStart.domain.dto;

import com.ss.quickStart.domain.User;

import java.util.List;


public class UserListDTO {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
