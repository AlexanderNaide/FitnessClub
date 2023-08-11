package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.*;
import ru.gb.testback.services.ScheduleService;
import ru.gb.testback.services.SubscriptionsService;

import java.util.List;


@RestController
@RequestMapping("/accounts/api/v1/clients")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestAccountController {

    private final SubscriptionsService subscriptionsService;

    @GetMapping("/accounts/info")
    public UserDto info(){
        return new UserDto();
    }

    @PostMapping("/accounts/info/update")
    public void saveUser(@RequestBody UserDto userDto){
        System.out.println("\nПришло:");
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getKeypass());
        System.out.println(userDto.getPhone());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
    }

    @GetMapping("/subscriptions/info")
    public List<SubscriptionDto> getUserSubscriptionList(){
        return subscriptionsService.getUserSubscriptionList();
    }

}
