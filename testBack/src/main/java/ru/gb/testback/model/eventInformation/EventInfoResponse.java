package ru.gb.testback.model.eventInformation;

import lombok.Data;

@Data
public class EventInfoResponse {
    private HallInfoResponse hall;
    private TrainerResponse trainer;
    private DisciplineResponse discipline;
    private Long id;
    private String date;
    private String startTime;
    private String duration;
    private String comment;

}
