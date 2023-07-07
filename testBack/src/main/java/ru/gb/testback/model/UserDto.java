package ru.gb.testback.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String keypass;
    private String username;
    private String phone;
    private String email;

    private String password;

    public UserDto() {
        this.id = 1L;
        this.keypass = "0000001";
        this.username = "First User";
        this.phone = "8-900-999-9999";
        this.email = "user@mail.ru";
    }
}
