package ru.gb.testback.model.eventInformation;

import lombok.Data;
import ru.gb.testback.model.Event;

@Data
public class HallInfoResponse implements Event {
    private String name;
    private String address;
    private String description;
}
