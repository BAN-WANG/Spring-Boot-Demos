package com.ss.quickStart.domain;

import javax.persistence.*;

/**
 * Created by wsy on 2017/8/8.
 * 实体类注解：http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/3.Use.md：第2点
 */
@Table(name = "user")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //主键策略：http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/3.Use.md：第3点
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "name")
    private String name;
    private Integer sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
