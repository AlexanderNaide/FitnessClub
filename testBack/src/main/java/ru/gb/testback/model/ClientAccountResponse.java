package ru.gb.testback.model;

import lombok.Data;

@Data
public class ClientAccountResponse {
    private Long id;
    private String login;
    private String keypass;
    private String username;
    private String phone;
    private String email;

    private String password;

    public ClientAccountResponse() {
        this.id = 1L;
        this.login = "login1";
        this.keypass = "0000001";
        this.username = "First User";
        this.phone = "8-900-999-9999";
        this.email = "user@mail.ru";
    }
}
