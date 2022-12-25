package com.lmar.mybatis.repository;

import com.lmar.mybatis.model.DTOs.LoginDTO;
import com.lmar.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface AuthRepository {

    @Insert("{ CALL checkUser( #{email}, #{password}, #{isValid, mode=OUT, jdbcType=INTEGER}) }")
    @Options(statementType = StatementType.CALLABLE)
    @ResultType(Integer.class)
    public int checkUser(LoginDTO loginDTO);

    @Select("{ CALL getUserByEmailPassword( #{email}, #{password}) }")
    @Options(statementType = StatementType.CALLABLE)
    @ResultType(User.class)
    public User getUserByEmailAndPassword(LoginDTO loginDTO);
}
