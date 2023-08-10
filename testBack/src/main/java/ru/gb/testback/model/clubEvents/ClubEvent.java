package ru.gb.testback.model.clubEvents;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ClubEvent {

    private Long id;

    private String discipline;

    private String coachName;

    private LocalDate eventDate;

    private LocalTime startTime;

    private String duration;

    private Hall hall;

    private String comments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<Participant> participants;



}
