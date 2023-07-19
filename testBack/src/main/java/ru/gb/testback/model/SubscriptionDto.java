package ru.gb.testback.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Data
public class SubscriptionDto {

    private Long id;
    private Integer numOfWorkouts;
    private String disciplineName;
//    private Date expired;
    private LocalDate expired;


    public SubscriptionDto() {
        this.id = 1L;
        this.numOfWorkouts = 10;
        this.disciplineName = "Yoga";
//        this.expired = new Date(124, Calendar.DECEMBER, 31);
        this.expired = LocalDate.of(2024, 12, 31);
    }
}
