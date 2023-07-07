package ru.gb.testback.model;

import lombok.Data;

@Data
public class TicketDto {
    private Long id;
    private String discipline;

    public TicketDto() {
        this.id = 1L;
        this.discipline = "Какая-то тренировка";
    }
}
