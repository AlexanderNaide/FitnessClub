package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.*;
import ru.gb.testback.model.subscriptions.SubscriptionResponse;
import ru.gb.testback.services.SubscriptionsService;

import java.util.List;


@RestController
@RequestMapping("/accounts/api/v1/clients")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestAccountController {

    private final SubscriptionsService subscriptionsService;

    @GetMapping("/accounts/info")
    public ClientAccountResponse info(){
        return new ClientAccountResponse();
    }

    @PostMapping("/accounts/info/update")
    public void saveUser(@RequestBody ClientAccountResponse clientAccountResponse){
        System.out.println("\nПришло:");
        System.out.println(clientAccountResponse.getUsername());
        System.out.println(clientAccountResponse.getKeypass());
        System.out.println(clientAccountResponse.getPhone());
        System.out.println(clientAccountResponse.getEmail());
        System.out.println(clientAccountResponse.getPassword());
    }

    @GetMapping("/subscriptions/info")
    public List<SubscriptionResponse> getUserSubscriptionList(){
        return subscriptionsService.getUserSubscriptionList();
    }

}
