package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.clubEvents.ClubEventResponse;
import ru.gb.testback.model.eventInformation.DisciplineResponse;
import ru.gb.testback.model.eventInformation.EventInfoResponse;
import ru.gb.testback.model.eventInformation.HallInfoResponse;
import ru.gb.testback.model.eventInformation.TrainerResponse;
import ru.gb.testback.model.subscriptions.SubscriptionFullInfoResponse;
import ru.gb.testback.model.subscriptions.SubscriptionResponse;
import ru.gb.testback.services.ScheduleService;
import ru.gb.testback.services.SubscriptionsService;

import java.util.List;


@RestController
@RequestMapping("/subscriptions/api/v1/subscriptions")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestSubscriptionController {

    private final SubscriptionsService subscriptionsService;
    private final ScheduleService scheduleService;


    @GetMapping("/get-all")
    public List<SubscriptionResponse> getAllSubscriptions(){
        return subscriptionsService.getAllSubscriptionList();
    }

    @PostMapping("/buy/{id}")
    public void addSubscriptionForUser(@PathVariable Long id){
        subscriptionsService.addSubscriptionForUser(id);
    }

    // Запрос на удаление абонемента - пока не нужен
/*    @PostMapping("/unsubscribe/{id}")
    public void deleteSubscriptionForUser(@PathVariable Long id){
        subscriptionsService.deleteSubscriptionForUser(id);
    }*/

    // Запрос подробной информации об абонементе.
    @GetMapping("/{id}/info")
    public SubscriptionFullInfoResponse getSubscriptionById(@PathVariable Long id){
        SubscriptionResponse subscriptionResponse = subscriptionsService.getSubscription(id);
        ClubEventResponse clubEventResponse = scheduleService.findEventResponseByTitle(subscriptionResponse.getDiscipline());

        TrainerResponse trainerResponse = new TrainerResponse();
        trainerResponse.setName(subscriptionResponse.getTrainer());

        DisciplineResponse disciplineResponse = new DisciplineResponse();
        disciplineResponse.setName(subscriptionResponse.getDiscipline());
        disciplineResponse.setDescription(scheduleService.findDescriptionByTitle(subscriptionResponse.getDiscipline()));

        SubscriptionFullInfoResponse subscriptionFullInfoResponse = new SubscriptionFullInfoResponse();
        subscriptionFullInfoResponse.setTrainer(trainerResponse);
        subscriptionFullInfoResponse.setDiscipline(disciplineResponse);
        subscriptionFullInfoResponse.setId(subscriptionResponse.getId());
        subscriptionFullInfoResponse.setImage(subscriptionResponse.getImage());
        subscriptionFullInfoResponse.setPrice(subscriptionResponse.getPrice());
        subscriptionFullInfoResponse.setWorkoutCount(subscriptionResponse.getWorkoutCount());
        if (clubEventResponse != null){
            subscriptionFullInfoResponse.setDuration(clubEventResponse.getDuration());
        }

        return subscriptionFullInfoResponse;
    }

}
