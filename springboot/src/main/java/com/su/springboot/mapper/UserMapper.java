package com.su.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {


    @Select("select * from sys_user")
    List<User> findall();

    @Insert("insert sys_user(username, password, nickname, email, phone, address) VALUES(#{username},#{password}," +
            "#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

//    @Update("update sys_user set username = #{username},password = #{password},nickname=#{nickname},email=" +
//            "#{email},phone=#{phone},address=#{address} where id=#{id}")
    //注解与xml不可同时再
//    int update(User user);
//
//    @Delete("delete from sys_user where id=#{id}")
//    Integer delete(@Param("id") Integer id);
//
//    @Select("select * from sys_user where username like #{username} limit #{pageNum},#{pageSize}")
//    List<User> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("username") String username);
//
//    @Select("select count(*) from sys_user where username like #{username}")
//    Integer selectTotal(String username);
}
