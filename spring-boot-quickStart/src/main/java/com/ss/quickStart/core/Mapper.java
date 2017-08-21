package com.ss.quickStart.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 自定义Mapper
 * 关于Mapper详解：http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/5.Mappers.md
 * @param <T>
 */
public interface Mapper<T> extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}

