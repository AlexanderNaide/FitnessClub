package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.AuthRequest;
import ru.gb.testback.model.AuthResponse;
import ru.gb.testback.model.RegRequest;
import ru.gb.testback.model.UserDto;
import ru.gb.testback.services.ScheduleService;


@RestController
@RequestMapping("/auth/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestAuthController {

    @PostMapping("/auth")
    public AuthResponse token(@RequestBody AuthRequest request){
        String token;

        if (request.getUsername().equals("admin")){
            token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY5MjA4ODYyNiwiaWF0IjoxNjkwODc5MDI2LCJhdXRob3JpdHkiOlsiYWRtaW4iXX0.ss8i0YmMUqWNx0uwlcilzZ2TFlD3MPVDwaCTfZ-zCEs";
        } else {
            token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTY5MjQ0MTUxMSwiaWF0IjoxNjkxMjMxOTExLCJhdXRob3JpdHkiOlsidXNlciJdfQ.47AgHIaOTT94fkteOVy3e7XtXjxPO3FSR6N_hWC_zW4";
        }
        return new AuthResponse(token);
    }

    @PostMapping("/registration")
    public AuthResponse reg(@RequestBody RegRequest request){
        // это для наглядности
        System.out.println("\nПришло:");
        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        System.out.println(request.getConfirmPassword());
        System.out.println(request.getRealName());
        System.out.println(request.getPhone());
        System.out.println(request.getEmail());


        // здесь логика регистрации, затем:

        AuthRequest authRequest = new AuthRequest(request.getUsername(), request.getPassword());
        return token(authRequest);
    }
}
