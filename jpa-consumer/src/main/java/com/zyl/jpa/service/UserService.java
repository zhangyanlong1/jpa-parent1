package com.zyl.jpa.service;

import com.zyl.jpa.entity.Depart;
import com.zyl.jpa.entity.MyPageImpl;
import com.zyl.jpa.entity.User;
import com.zyl.jpa.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// ,fallback = UserServiceFailBack.class
@FeignClient(value = "jpa-service")
public interface UserService {

    @RequestMapping("/user/list")
    MyPageImpl<User> list(@RequestBody UserVo userVo);

    @RequestMapping("/user/del")
    Boolean del(@RequestParam(value = "id") int id);

    @RequestMapping("/user/add")
    boolean add(@RequestBody User user);

    @RequestMapping("/user/departs")
    List<Depart> listDeparts();
}
