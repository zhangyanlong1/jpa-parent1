package com.zyl.jpa.service;

import com.zyl.jpa.entity.Depart;
import com.zyl.jpa.entity.MyPageImpl;
import com.zyl.jpa.entity.User;
import com.zyl.jpa.entity.UserVo;

import java.util.List;

public interface UserService {

    MyPageImpl list(UserVo userVo);

    boolean del(int id);

    boolean add(User user);

    // 获取部门的列表
    List<Depart> listDeparts();
}
