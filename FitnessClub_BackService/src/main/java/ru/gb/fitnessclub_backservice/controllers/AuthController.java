package ru.gb.fitnessclub_backservice.controllers;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.fitnessclub_backservice.model.entities.User;
import ru.gb.fitnessclub_backservice.services.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setUsername("Вася");
        userService.save(user);
        getUser();
    }

    public void getUser(){
        Optional<User> user = userService.findUserByUsername("Вася");
        user.ifPresent(u -> System.out.println(u.getUsername()));
    }
}
