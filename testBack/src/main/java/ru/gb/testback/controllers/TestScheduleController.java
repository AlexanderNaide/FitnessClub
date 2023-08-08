package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.SubscriptionDto;
import ru.gb.testback.model.SubscriptionResponse;
import ru.gb.testback.model.clubEvents.ScheduleFrontResponse;
import ru.gb.testback.services.ScheduleService;
import ru.gb.testback.services.SubscriptionsService;

import java.util.List;


@RestController
@RequestMapping("/schedule-service/api/v1/events")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/general")
    public ScheduleFrontResponse getSchedule(){
        return scheduleService.getSchedule();
//        return null;
    }

    @PostMapping("/buy/{id}")
    public void addSubscriptionForUser(@PathVariable Long id){
//        subscriptionsService.addSubscriptionForUser(id);
    }

    @GetMapping("/{id}")
    public SubscriptionResponse getSubscriptionById(@PathVariable Long id){
//        return subscriptionsService.getSubscription(id);
        return null;
    }

}
