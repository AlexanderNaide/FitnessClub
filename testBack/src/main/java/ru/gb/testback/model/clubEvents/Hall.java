package ru.gb.testback.model.clubEvents;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Hall {

    private Long id;

    private String trigger;

    private String name;

    private String address;

    private String description;

    List<ClubEvent> events;

}
