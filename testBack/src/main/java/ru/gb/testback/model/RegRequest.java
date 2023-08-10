package ru.gb.testback.model;

import lombok.Getter;

@Getter
public class RegRequest {

    private String username;
    private String password;
    private String confirmPassword;
    private String realName;
    private String phone;
    private String email;

}
