package com.lmar.mybatis.controller;

import com.lmar.mybatis.model.DTOs.LoginDTO;
import com.lmar.mybatis.model.User;
import com.lmar.mybatis.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @PostMapping("/auth/login")
    public LoginDTO loginUser(@RequestBody LoginDTO loginDTO) {
        authRepository.checkUser(loginDTO);
        return loginDTO;
    }

    @PostMapping("/auth/getUserByEmailAndPassword")
    public User getUserByEmailAndPassword(@RequestBody LoginDTO loginDTO) {
        return authRepository.getUserByEmailAndPassword(loginDTO);
    }
}
