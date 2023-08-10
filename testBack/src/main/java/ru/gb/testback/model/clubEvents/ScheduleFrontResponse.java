package ru.gb.testback.model.clubEvents;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.testback.model.Event;

import java.util.*;

@Data
@NoArgsConstructor
public class ScheduleFrontResponse {

    private LinkedHashMap<String, String> halls;
    private List<String> daysOFWeek;
    private List<String> trainingStartTime;
    private List<DayScheduleResponse> events;


    public ScheduleFrontResponse(LinkedHashMap<String, String> halls, List<String> daysOFWeek, List<String> scheduleTimer, List<DayScheduleResponse> events) {
        this.halls = halls;
        this.daysOFWeek = daysOFWeek;
        this.trainingStartTime = scheduleTimer;
        this.events = events;
    }

}
