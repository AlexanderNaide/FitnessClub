package ru.gb.testback.model.clubEvents;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ClubEventResponse(Long id, String discipline, String comments, String coachName, String eventDate, String startTime, String duration, Integer hall) {
        this.id = id;
        this.discipline = discipline;
        this.coachName = coachName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.duration = duration;
        this.hall = switch (hall){
            case 2 -> "dance";
            case 3 -> "green";
            case 4 -> "little";
            default -> "fitness";
        };
        this.comments = comments;
    }
}
