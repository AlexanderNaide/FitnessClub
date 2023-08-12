package ru.gb.testback.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubscriptionDto {

    private Long id;
    private Integer numOfWorkouts;
    private String disciplineName;
    private LocalDate expired;

    public SubscriptionDto(Long id, Integer numOfWorkouts, String disciplineName, LocalDate expired) {
        this.id = id;
        this.numOfWorkouts = numOfWorkouts;
        this.disciplineName = disciplineName;
        this.expired = expired;
    }
}
