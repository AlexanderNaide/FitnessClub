package ru.gb.testback.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.testback.model.ClassDto;
import ru.gb.testback.model.Event;
import ru.gb.testback.model.SubscriptionDto;
import ru.gb.testback.model.SubscriptionResponse;
import ru.gb.testback.model.clubEvents.*;
import ru.gb.testback.repositories.SchedulesRepository;

import java.time.LocalDate;
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

    public List<Event> getScheduleList() {
        return schedulesRepository.findAll().values().stream().toList();
    }

    public ScheduleFrontResponse getSchedule() {
        List<Event> listEvent = schedulesRepository.findAll().values().stream().toList();
        List<String> scheduleTimer = listEvent.stream().map(e -> (ClassDto) e).map(ClassDto::getTime).collect(Collectors.toSet()).stream().sorted().toList();
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

    private List<DayScheduleResponse> sortEventsByDays(List<Event> events) {
        List<DayScheduleResponse> weekSchedule = new ArrayList<>();
        for (String day : daysOfWeek) {
            DayScheduleResponse dayResponse = new DayScheduleResponse();
            dayResponse.setDayOfWeek(day);
            dayResponse.setEventsOfADay(events.stream().map(e -> (ClassDto) e).filter(e -> e.getDay().equals(day)).map(Converter::convertToEventResponse).toList());
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
        ClassDto event = (ClassDto) schedulesRepository.findById(id);
        if(subscriptionsService.isSubscribe(event.getTitle())){
            userEvents.put(id, Converter.convertToEventResponse(event));
        }
    }

    public void deleteEventForUser(Long id) {
        userEvents.remove(id);
    }

    public ClassDto getEventById(Long id){
        return (ClassDto) schedulesRepository.findById(id);
    }

    public String findDescriptionByTitle(String title){
        return schedulesRepository.findDescriptionByTitle(title);
    }
}
