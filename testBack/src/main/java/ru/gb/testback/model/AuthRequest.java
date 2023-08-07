package ru.gb.testback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;

}
