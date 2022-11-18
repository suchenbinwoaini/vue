package com.su.springboot.mapper;

import com.su.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {


    @Select("select * from sys_user")
    List<User> findall();

    @Insert("insert sys_user(username, password, nickname, email, phone, address) VALUES(#{username},#{password}," +
            "#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

//    @Update("update sys_user set username = #{username},password = #{password},nickname=#{nickname},email=" +
//            "#{email},phone=#{phone},address=#{address} where id=#{id}")
    //注解与xml不可同时再
    int update(User user);

    @Delete("delete from sys_user where id=#{id}")
    Integer delete(@Param("id") Integer id);
}
