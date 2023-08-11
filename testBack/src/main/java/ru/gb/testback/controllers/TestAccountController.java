package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.*;
import ru.gb.testback.services.ScheduleService;

import java.util.List;


@RestController
@RequestMapping()
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestAccountController {

    private final ScheduleService scheduleService;

    @PostMapping("/auth/api/v1/auth")
    public AuthResponse token(@RequestBody AuthRequest request){
        String token;

        if (request.getUsername().equals("admin")){
            token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY5MjA4ODYyNiwiaWF0IjoxNjkwODc5MDI2LCJhdXRob3JpdHkiOlsiYWRtaW4iXX0.ss8i0YmMUqWNx0uwlcilzZ2TFlD3MPVDwaCTfZ-zCEs";
        } else {
            token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTY5MjQ0MTUxMSwiaWF0IjoxNjkxMjMxOTExLCJhdXRob3JpdHkiOlsidXNlciJdfQ.47AgHIaOTT94fkteOVy3e7XtXjxPO3FSR6N_hWC_zW4";
        }
        return new AuthResponse(token);
    }

    @PostMapping("/auth/api/v1/registration")
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

    @GetMapping("/accounts/api/v1/clients/accounts/info")
    public UserDto info(){
        return new UserDto();
    }

    @PostMapping("/accounts/api/v1/clients/accounts/info/update")
    public void saveUser(@RequestBody UserDto userDto){
        System.out.println("\nПришло:");
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getKeypass());
        System.out.println(userDto.getPhone());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
    }

/*    @GetMapping("/user-service/subscriptions")
    public List<SubscriptionDto> tickets(){
        return List.of(new SubscriptionDto(), new SubscriptionDto());
    }*/

/*    @GetMapping("/user-service/subscriptions/{id}")
    public void getOrderById(@PathVariable Long id){
        System.out.println(id);
    }*/


/*    @GetMapping("/user-service/schedule")
    public List<Event> getSchedule(){
        return scheduleService.getScheduleList();
    }*/

}
