package com.ss.quickStart.domain.dto;

import com.ss.quickStart.domain.Order;

import java.util.List;

public class UserOrdersDTO {
    private Long id;
    private String userName;
    private List<Order> orderList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
