package ru.gb.fitnessclub_backservice.controllers;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.fitnessclub_backservice.model.entities.userStructure.User;
import ru.gb.fitnessclub_backservice.model.enums.Gender;
import ru.gb.fitnessclub_backservice.model.enums.Role;
import ru.gb.fitnessclub_backservice.services.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Вася");
        user.setRole(Role.USER);
        user.setGender(Gender.MAN);
        userService.save(user);
        getUser();
    }

    public void getUser(){
        Optional<User> user = userService.findUserByUsername("Вася");
        user.ifPresent(u -> System.out.println(u.getName()));
        user.ifPresent(u -> System.out.println(u.getRole()));
    }
}
