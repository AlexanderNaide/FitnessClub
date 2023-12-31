package ru.gb.testback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.clubEvents.ClubEventResponse;
import ru.gb.testback.model.clubEvents.ScheduleFrontResponse;
import ru.gb.testback.model.eventInformation.DisciplineResponse;
import ru.gb.testback.model.eventInformation.EventInfoResponse;
import ru.gb.testback.model.eventInformation.HallInfoResponse;
import ru.gb.testback.model.eventInformation.TrainerResponse;
import ru.gb.testback.services.ScheduleService;

import java.util.List;


@RestController
@RequestMapping("/schedule/api/v1/events")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/general")
    public ScheduleFrontResponse getSchedule(){
        return scheduleService.getSchedule();
    }

    // Метод для отправки списка абонементов (на фронте пока без него)
/*    @GetMapping("/subscription")
    public List<String> getUserSubscriptions(){
        return scheduleService.getUserSubscriptionList().stream().map(SubscriptionDto::getDisciplineName).toList();
    }*/

    @GetMapping("/personal")
    public List<Long> getUserEvents(){
        return scheduleService.getUserSchedule();
    }

    @PostMapping("/subscribe/{id}")
    public void addEventForUser(@PathVariable Long id){
        scheduleService.addEventForUser(id);
    }

    @PostMapping("/unsubscribe/{id}")
    public void deleteEventForUser(@PathVariable Long id){
        scheduleService.deleteEventForUser(id);
    }

    @GetMapping("/{id}/info")
    public EventInfoResponse getSubscriptionById(@PathVariable Long id){
        ClubEventResponse clubEventResponse = scheduleService.getEventById(id);

        DisciplineResponse disciplineResponse = new DisciplineResponse();
        disciplineResponse.setName(clubEventResponse.getDiscipline());
        disciplineResponse.setDescription(scheduleService.findDescriptionByTitle(clubEventResponse.getDiscipline()));

        TrainerResponse trainerResponse = new TrainerResponse();
        trainerResponse.setName(clubEventResponse.getCoachName());
        trainerResponse.setDescription("Какая-то информация о тренере,которую желательно заполнить");

        HallInfoResponse hallInfoResponse = new HallInfoResponse();
        hallInfoResponse.setName(ScheduleService.halls.get(clubEventResponse.getHall()));
        hallInfoResponse.setAddress("Местоположение зала.");
        hallInfoResponse.setDescription("");

        EventInfoResponse eventInfoResponse = new EventInfoResponse();
        eventInfoResponse.setHall(hallInfoResponse);
        eventInfoResponse.setTrainer(trainerResponse);
        eventInfoResponse.setDiscipline(disciplineResponse);
        eventInfoResponse.setId(clubEventResponse.getId());
        eventInfoResponse.setDate(clubEventResponse.getEventDate());
        eventInfoResponse.setStartTime(clubEventResponse.getStartTime());
        eventInfoResponse.setDuration(clubEventResponse.getDuration());
        eventInfoResponse.setComment(clubEventResponse.getComments());

        return eventInfoResponse;
    }

}
