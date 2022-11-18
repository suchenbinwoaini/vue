package com.su.springboot.service;

import com.su.springboot.entity.User;
import com.su.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public int save(User user){
        if (user.getId()==null)
            return userMapper.insert(user);
        else
            return userMapper.update(user);
    }
}
