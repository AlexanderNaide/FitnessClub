package ru.gb.testback.model.clubEvents;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayScheduleResponse {

    private String dayOfWeek;

    private List<ClubEventResponse> eventsOfADay;

}
