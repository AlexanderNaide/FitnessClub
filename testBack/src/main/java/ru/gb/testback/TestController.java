package ru.gb.testback;

import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class TestController {

    @PostMapping("/auth-service/auth")
    public AuthResponse token(@RequestBody AuthRequest request){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTY5MDk1ODE4MSwiaWF0IjoxNjg5NzQ4NTgxLCJhdXRob3JpdHkiOlsidXNlciJdfQ.dq7JV4_77obArhztZX3W4rNhH_ffyNRmWuP9iekDE7Y";
        return new AuthResponse(token);
    }

    @PostMapping("/auth-service/reg")
    public AuthResponse reg(@RequestBody AuthRequest request){
        return token(request);
    }

    @GetMapping("/user-service/info")
    public UserDto info(){
        return new UserDto();
    }

    @PostMapping("/user-service/save")
    public void saveUser(@RequestBody UserDto userDto){
        System.out.println("\nПришло:");
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getKeypass());
        System.out.println(userDto.getPhone());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
    }

    @GetMapping("/user-service/subscriptions")
    public List<SubscriptionDto> tickets(){
        return List.of(new SubscriptionDto(), new SubscriptionDto());
    }

    @GetMapping("/user-service/subscriptions/{id}")
    public void getOrderById(@PathVariable Long id){
        System.out.println(id);
    }



}
