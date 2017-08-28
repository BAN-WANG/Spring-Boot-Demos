package com.ss.quickStart.dao;

import com.ss.quickStart.core.Mapper;
import com.ss.quickStart.domain.User;
import com.ss.quickStart.domain.dto.UserOrdersDTO;
import org.apache.ibatis.annotations.*;

public interface UserMapper extends Mapper<User> {

    @Select("select id ,name from user where id = #{userId}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "userName"),
            @Result(column = "id",property = "orderList",
                    many = @Many(select = "com.ss.quickStart.dao.OrderMapper.qryOrdersByUserIdLastTwo"))
    })
    UserOrdersDTO qryUserOrders2(@Param("userId") Long userId);

    UserOrdersDTO qryUserOrders3(@Param("userId") Long userId);
}
