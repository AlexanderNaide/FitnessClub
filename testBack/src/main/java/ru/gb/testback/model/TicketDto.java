package ru.gb.testback.model;

import lombok.Data;

import java.util.Date;

@Data
public class TicketDto {
    private Long id;
    private String discipline;

    private Date expired;

    public TicketDto() {
        this.id = 1L;
        this.discipline = "Какая-то тренировка";
    }
}
