package ru.gb.testback.model.eventInformation;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.testback.model.Event;
import ru.gb.testback.model.clubEvents.ClubEvent;

import java.util.List;

@Data
public class DisciplineResponse implements Event {
    private String name;
    private String description;
}
