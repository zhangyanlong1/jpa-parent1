package com.zyl.jpa.controller;


import com.zyl.jpa.entity.Depart;
import com.zyl.jpa.entity.MyPageImpl;
import com.zyl.jpa.entity.User;
import com.zyl.jpa.entity.UserVo;
import com.zyl.jpa.repository.UserRepository;
import com.zyl.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRep;

    @Autowired
    UserService userService;

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("testaa")
    public String testAdd(){
        User user = new User();
        user.setUsername("mytest");
        userRep.save(user);
        return "ok";
    }

    @RequestMapping("list")
    public MyPageImpl<User> list(@RequestBody UserVo userVo){
        System.out.print(" 服务提供者  参数是  " + userVo);

        MyPageImpl<User> userPage = userService.list(userVo);
        log.info(" 已经获取数据了。。。。。。。。。。。。");
        userPage.getContent().iterator().forEachRemaining(x->{System.out.println("x is " + x);});
        log.info("page.class is " + userPage.getClass());
        return userPage;
    }

    @RequestMapping("del")
    public boolean del(@RequestParam(value = "id") int id){
        PhysicalNamingStrategyStandardImpl t;
        return userService.del(id);


    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return userService.add(user);
    }

    @RequestMapping("departs")
    public List<Depart> getDeparts(){
        return  userService.listDeparts();
    }





}
