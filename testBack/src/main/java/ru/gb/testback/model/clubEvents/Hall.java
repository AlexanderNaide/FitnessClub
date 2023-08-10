package ru.gb.testback.model.clubEvents;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.testback.model.Event;

import java.util.List;

@Data
@NoArgsConstructor
public class Hall implements Event {

    private Long id;

    private String trigger;

    private String name;

    private String address;

    private String description;

    List<ClubEvent> events;

}
