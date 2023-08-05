package ru.gb.testback.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ScheduleDto {


    List<String> week;


    List<List<ClassDto>> schedule;

    public ScheduleDto() {
        this.week = List.of(
                "Понедельник",
                "Вторник",
                "Среда",
                "Четверг",
                "Пятница",
                "Суббота",
                "Воскресенье"
        );

        this.schedule = schedule;
    }
}
