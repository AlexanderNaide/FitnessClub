package ru.gb.testback.model;

import lombok.Data;

@Data
public class ClassDto implements Event {
    private Long id;
    private String title;
    private String message;
    private String trainer;
    private String day;
    private String time;
    private String place;

    public ClassDto(Long id, String title, String message, String trainer, String day, String time, int place) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.trainer = trainer;
        this.day = day;
        this.time = time;
        this.place = switch (place){
            case 2 -> "dance";
            case 3 -> "green";
            case 4 -> "little";
            default -> "fitness";
        };
    }
}
