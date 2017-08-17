package com.ss.quickStart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ss.quickStart.conf.PropertiesValues;
import com.ss.quickStart.domain.User;
import com.ss.quickStart.domain.dto.UserListDTO;
import com.ss.quickStart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by wsy on 2017/8/8.
 */
@RestController
public class UserController {
    @Autowired
    private PropertiesValues propertiesValues;

    @Resource
    private UserService userService;

    //取配置文件中author.name值，若没有则赋值为ss
    @Value("${author.name:ss}")
    private String name;

    @RequestMapping("getUser.do")
    public User getUser(){
        User user = new User();
        user.setName(propertiesValues.getUserName());
        user.setSex(1);
        System.out.println(MessageFormat.format("name=>{0}",name));
        return user;
    }

    @RequestMapping("user/getById.do")
    public User getById(Long id){
        return userService.getById(id);
    }

    @RequestMapping("user/add.do")
    public Boolean add(User user){
        return userService.add(user);
    }

    /**
     * 通过JSON方式解析入参：请求头中content-type:application/json;Request Body:{"name": "AA","sex": 1}
     * localhost:8080/user/addByJSON.do?{"name": "AA","sex": 1}
     * @param user
     * @return
     */
    @RequestMapping("user/addByJSON.do")
    public Boolean addByJSON(@RequestBody User user){
        return userService.add(user);
    }

    /**
     * 批量添加用户:
     * localhost:8080/user/batchAdd.do?userList[0].name=A&userList[0].sex=1&userList[1].name=B&userList[1].sex=0
     * @param userListDTO
     * @return
     */
    @RequestMapping("user/batchAdd.do")
    public Boolean batchAdd(UserListDTO userListDTO){
        return userService.batchAdd(userListDTO.getUserList());
    }

    @RequestMapping("/list")
    public PageInfo list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
