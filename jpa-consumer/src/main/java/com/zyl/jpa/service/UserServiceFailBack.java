package com.zyl.jpa.service;

import com.zyl.jpa.entity.Depart;
import com.zyl.jpa.entity.MyPageImpl;
import com.zyl.jpa.entity.User;
import com.zyl.jpa.entity.UserVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 熔断
 */
@Component
public class UserServiceFailBack  implements  UserService{

    @Override
    public MyPageImpl<User> list(@RequestBody UserVo userVo) {
        System.out.println(" 对不起，熔断了。。。。");
                return  null;
    }

    @Override
    public Boolean del(int id) {
         return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<Depart> listDeparts() {
        return new ArrayList<Depart>();
    }
}
