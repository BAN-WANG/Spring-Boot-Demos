package com.ss.quickStart.dao;

import com.ss.quickStart.core.Mapper;
import com.ss.quickStart.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {

    @Select("SELECT id,user_id,order_money,order_time FROM t_order WHERE user_id = #{userId} ORDER BY order_time DESC limit 2")
    @ResultMap("BaseResultMap")
    List<Order> qryOrdersByUserIdLastTwo(@Param("userId") String userId);
}