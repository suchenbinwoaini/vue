package com.su.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.su.springboot.entity.User;
import com.su.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    @Resource
    private UserMapper userMapper;


    public boolean saveUser(User user) {
//        if (user.getId()==null)
//            return save(user);
//        else
//            return update(user);
//    }
        return saveOrUpdate(user);
    }
}
