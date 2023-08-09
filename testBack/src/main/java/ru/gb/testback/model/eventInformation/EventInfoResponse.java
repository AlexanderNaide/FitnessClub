package ru.gb.testback.model.eventInformation;

import lombok.Data;
import ru.gb.testback.model.Event;

@Data
public class EventInfoResponse implements Event {
    private HallInfoResponse hall;
    private TrainerResponse trainer;
    private DisciplineResponse discipline;
    private String date;
    private String startTime;
    private String duration;
}
