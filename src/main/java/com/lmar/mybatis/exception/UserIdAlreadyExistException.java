package com.lmar.mybatis.exception;

public class UserIdAlreadyExistException extends RuntimeException{
    public UserIdAlreadyExistException() {
        super("User Id Already Exist");
    }
}
