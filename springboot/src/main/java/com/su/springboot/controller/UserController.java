package com.su.springboot.controller;

import com.su.springboot.entity.User;
import com.su.springboot.mapper.UserMapper;
import com.su.springboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> index(){
        return userMapper.findall();
    }

    @PostMapping
    public Integer save(@RequestBody User user){
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.delete(id);
    }
}
