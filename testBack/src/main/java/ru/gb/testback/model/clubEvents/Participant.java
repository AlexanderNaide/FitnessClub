package ru.gb.testback.model.clubEvents;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Participant {

    private Long id;

    private String login;

    private String name;

    private ClubEvent clubEvent;

    private Long subscriptionID;

}
