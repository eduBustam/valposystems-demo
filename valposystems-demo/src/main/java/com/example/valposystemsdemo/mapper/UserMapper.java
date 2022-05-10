package com.example.valposystemsdemo.mapper;

import com.example.valposystemsdemo.model.UserModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    ArrayList<UserModel>findAll();

    @Delete("delete from users where id=#{id}")
    void deleteById(@PathParam("id") long id);
    @Insert("insert into users (email,username) values(#{email},#{username})")
    @SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id", before=false, resultType = Integer.class)
    void save(@PathParam("email") final String email,@PathParam("username")final String username);

    @Update("update users set username=#{username},email=#{email} where id=#{id}")
    void putUser(@PathParam("email") final String email,@PathParam("username")final String username,@PathParam("id")long id);
}
