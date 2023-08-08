package ru.gb.testback.model.clubEvents;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.testback.model.ClassDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubEventResponse {

    private Long id;

    private String discipline;

    private String coachName;

    private String eventDate;

    private String startTime;

    private String duration;

    private String hall;//trigger

    private String comments;

}
