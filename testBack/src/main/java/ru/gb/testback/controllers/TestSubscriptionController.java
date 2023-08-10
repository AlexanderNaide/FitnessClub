package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.*;
import ru.gb.testback.services.ScheduleService;
import ru.gb.testback.services.SubscriptionsService;

import java.util.List;


@RestController
@RequestMapping("/subscriptions-service/api/v1/subscriptions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestSubscriptionController {

    private final SubscriptionsService subscriptionsService;

    @GetMapping()
    public List<SubscriptionDto> getUserSubscriptionList(){
        return subscriptionsService.getUserSubscriptionList();
    }

    @GetMapping("/get-all")
    public List<SubscriptionResponse> getAllSubscriptions(){
        return subscriptionsService.getAllSubscriptionList();
    }

    @PostMapping("/subscribe/{id}")
    public void addSubscriptionForUser(@PathVariable Long id){
        subscriptionsService.addSubscriptionForUser(id);
    }

    @PostMapping("/unsubscribe/{id}")
    public void deleteSubscriptionForUser(@PathVariable Long id){
        subscriptionsService.deleteSubscriptionForUser(id);
    }

    @GetMapping("/{id}")
    public SubscriptionResponse getSubscriptionById(@PathVariable Long id){
        return subscriptionsService.getSubscription(id);
    }

}
