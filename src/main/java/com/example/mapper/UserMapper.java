package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into tb_user(account_id, name, token, gmt_create,gmt_modified) " +
            "values(#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})")
    void addUser(User user);
}
