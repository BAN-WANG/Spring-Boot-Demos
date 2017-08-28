package com.ss.quickStart.service;

import com.github.pagehelper.PageHelper;
import com.ss.quickStart.dao.OrderMapper;
import com.ss.quickStart.dao.UserMapper;
import com.ss.quickStart.domain.Order;
import com.ss.quickStart.domain.User;
import com.ss.quickStart.domain.dto.UserOrdersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    private static final Logger  LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderMapper orderMapper;

    public User getById(long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public Boolean add(User user){
        int count = userMapper.insert(user);
        LOG.info("新增用户id=>{}",user.getId());
        return count==1?true:false;
    }

    public Boolean batchAdd(List<User> userList){
        int count = userMapper.insertList(userList);
        return true;
    }

    public List<User> findAll(){
        //return userMapper.selectAll();
        Condition condition = new Condition(User.class);
        condition.setOrderByClause("id DESC");
        return userMapper.selectByCondition(condition);
    }

    public List<User> listByCondition(){
        //return userMapper.selectAll();
        Condition condition = new Condition(User.class);
        condition.createCriteria().andLike("name","s%").andEqualTo("sex",0);
        condition.setOrderByClause("id DESC");
        return userMapper.selectByCondition(condition);
    }

    public Boolean addOrder(Order order){
       orderMapper.insert(order);
        return true;
    }

    public UserOrdersDTO qryUserOrders(Long userId){
        UserOrdersDTO userOrdersDTO = new UserOrdersDTO();

        //步骤一：查询用户信息
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            return userOrdersDTO;
        }
        userOrdersDTO.setId(userId);
        userOrdersDTO.setUserName(user.getName());

        //步骤二：查询用户最近2个订单
        PageHelper.startPage(1, 2);
        Condition condition = new Condition(Order.class);
        condition.createCriteria().andEqualTo("userId",userId);
        condition.setOrderByClause("order_time desc");
        List<Order> orderList = orderMapper.selectByCondition(condition);
        userOrdersDTO.setOrderList(orderList);
        return userOrdersDTO;
    }

    public UserOrdersDTO qryUserOrders2(Long userId){
        return userMapper.qryUserOrders2(userId);
    }

    public UserOrdersDTO qryUserOrders3(Long userId){
        return userMapper.qryUserOrders3(userId);
    }
}
