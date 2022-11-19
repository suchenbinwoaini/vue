package com.su.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.springboot.entity.User;
import com.su.springboot.mapper.UserMapper;
import com.su.springboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findall(){
        return userService.list();
    }

    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

//    @GetMapping("/page")
//    public Map<String,Object> findpage(@RequestParam Integer pageNum,
//                                       @RequestParam Integer pageSize,
//                                       @RequestParam String username){
//        pageNum = (pageNum-1)*pageSize;
//        username = "%"+username+"%";
//        List<User> data = userMapper.selectPage(pageNum,pageSize,username);
//        Integer total = userMapper.selectTotal(username);
//        Map<String,Object> res = new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }
    @GetMapping("/page")
    public IPage<User> findpage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam String username){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",username);
        IPage<User> userPage = userService.page(page, queryWrapper);
        return userPage;
    }
}
