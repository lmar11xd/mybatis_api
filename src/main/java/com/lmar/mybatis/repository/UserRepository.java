package com.lmar.mybatis.repository;

import com.lmar.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM users")
    public List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    public User findById(long id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO users(id,firstName,lastName,email,password) VALUES (#{id}, #{firstName}, #{lastName}, #{email}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(User user);

    @Update("UPDATE users SET firstName=#{firstName}, lastName=#{lastName}, email=#{email}, password=#{password} WHERE id=#{id}")
    public int update(User user);
}
