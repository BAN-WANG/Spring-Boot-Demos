package com.ss.quickStart.service;

import com.ss.quickStart.dao.OrderMapper;
import com.ss.quickStart.dao.UserMapper;
import com.ss.quickStart.domain.Order;
import com.ss.quickStart.domain.User;
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
}
