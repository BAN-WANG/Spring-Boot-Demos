package com.demo.quickStart.dao;

import com.demo.quickStart.BaseJunitTests;
import com.ss.quickStart.dao.UserMapper;
import com.ss.quickStart.domain.User;
import com.ss.quickStart.domain.dto.UserOrdersDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseJunitTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQryUserOrders3(){
        UserOrdersDTO userOrdersDTO = userMapper.qryUserOrders3(1L);
        Assert.assertTrue(userOrdersDTO != null && userOrdersDTO.getOrderList().size() > 0);
    }

    @Test
    public void testAdd(){
        User user = new User();
        user.setName("小王");
        user.setSex(1);
        int count = userMapper.insert(user);
        Assert.assertTrue(count == 1);
    }
}
