package ru.gb.testback.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.testback.model.SubscriptionDto;
import ru.gb.testback.model.clubEvents.*;
import ru.gb.testback.repositories.SchedulesRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final SchedulesRepository schedulesRepository;
    private final SubscriptionsService subscriptionsService;

    private Map<Long, ClubEventResponse> userEvents;

    private static final List<String> daysOfWeek = List.of(
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье"
    );

    public static final LinkedHashMap<String, String> halls;
    static {
        halls = new LinkedHashMap<>();
        halls.put("fitness", "ФИТНЕС ЗАЛ");
        halls.put("green", "ЗЕЛЕНЫЙ ЗАЛ (2 этаж)");
        halls.put("dance", "ТАНЦЕВАЛЬНЫЙ ЗАЛ");
        halls.put("little", "МАЛЫЙ ЗАЛ   (2 этаж)");
    }

    public List<ClubEventResponse> getScheduleList() {
        return schedulesRepository.findAll().values().stream().toList();
    }

    public ScheduleFrontResponse getSchedule() {
        List<ClubEventResponse> listEvent = schedulesRepository.findAll().values().stream().toList();
        List<String> scheduleTimer = listEvent.stream().map(ClubEventResponse::getStartTime).collect(Collectors.toSet()).stream().sorted().toList();
        List<DayScheduleResponse> events = sortEventsByDays(listEvent);
        return new ScheduleFrontResponse(halls, daysOfWeek, scheduleTimer, events);
    }

    public List<Long> getUserSchedule() {
        if(userEvents == null || userEvents.size() == 0){
            return new ArrayList<>();
        } else {
            return userEvents.keySet().stream().toList();
        }
    }

    private List<DayScheduleResponse> sortEventsByDays(List<ClubEventResponse> events) {
        List<DayScheduleResponse> weekSchedule = new ArrayList<>();
        for (String day : daysOfWeek) {
            DayScheduleResponse dayResponse = new DayScheduleResponse();
            dayResponse.setDayOfWeek(day);
            dayResponse.setEventsOfADay(events.stream().filter(e -> e.getEventDate().equals(day)).toList());
            weekSchedule.add(dayResponse);
        }
        return weekSchedule;
    }

    public List<SubscriptionDto> getUserSubscriptionList() {
        return subscriptionsService.getUserSubscriptionList();
    }

    public void addEventForUser(Long id) {
        if(userEvents == null){
            userEvents = new HashMap<>();
        }
        ClubEventResponse event = schedulesRepository.findById(id);
        if(subscriptionsService.isSubscribe(event.getDiscipline())){
            userEvents.put(id, event);
        }
    }

    public void deleteEventForUser(Long id) {
        userEvents.remove(id);
    }

    public ClubEventResponse getEventById(Long id){
        return schedulesRepository.findById(id);
    }

    public String findDescriptionByTitle(String title){
        return schedulesRepository.findDescriptionByTitle(title);
    }
}
