package ru.gb.testback;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestController {

    private final ScheduleService scheduleService;

    @PostMapping("/auth-service/auth")
    public AuthResponse token(@RequestBody AuthRequest request){
        String token;

        if (request.getUsername().equals("admin")){
            token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY5MjA4ODYyNiwiaWF0IjoxNjkwODc5MDI2LCJhdXRob3JpdHkiOlsiYWRtaW4iXX0.ss8i0YmMUqWNx0uwlcilzZ2TFlD3MPVDwaCTfZ-zCEs";
        } else {
            token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTY5MjQ0MTUxMSwiaWF0IjoxNjkxMjMxOTExLCJhdXRob3JpdHkiOlsidXNlciJdfQ.47AgHIaOTT94fkteOVy3e7XtXjxPO3FSR6N_hWC_zW4";
        }
        return new AuthResponse(token);
    }

    @PostMapping("/auth-service/reg")
    public AuthResponse reg(@RequestBody RegRequest request){
        System.out.println("\nПришло:");
        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        System.out.println(request.getConfirmPassword());
        System.out.println(request.getRealName());
        System.out.println(request.getPhone());
        System.out.println(request.getEmail());


        //логика регистрации, затем:

        AuthRequest authRequest = new AuthRequest(request.getUsername(), request.getPassword());
        return token(authRequest);
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


    @GetMapping("/user-service/schedule")
    public List<ClassDto> getSchedule(){
        return scheduleService.getScheduleList();
    }

}
