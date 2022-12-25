package com.lmar.mybatis.model.DTOs;

public class LoginDTO {
    private String email;
    private String password;
    private int isValid;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password, int isValid) {
        this.email = email;
        this.password = password;
        this.isValid = isValid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }
}
