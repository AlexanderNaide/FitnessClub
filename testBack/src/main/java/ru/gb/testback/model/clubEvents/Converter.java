package ru.gb.testback.model.clubEvents;

import ru.gb.testback.model.ClassDto;

public class Converter {

    public static ClubEventResponse convertToEventResponse(ClassDto classDto){
        ClubEventResponse response = new ClubEventResponse();
        response.setId(classDto.getId());
        response.setDiscipline(classDto.getTitle());
        response.setCoachName(classDto.getTrainer());
        response.setEventDate(classDto.getDay());
        response.setStartTime(classDto.getTime());
        response.setDuration("60 мин.");
        response.setHall(classDto.getPlace());
        response.setComments(classDto.getMessage());

        return response;
    }
}
