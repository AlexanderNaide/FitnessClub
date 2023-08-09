package ru.gb.testback.model.eventInformation;

import lombok.Data;
import ru.gb.testback.model.Event;

@Data
public class TrainerResponse implements Event {
    private String name;
    private String description;
}
