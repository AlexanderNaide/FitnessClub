package ru.gb.testback.model.subscriptions;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.testback.model.eventInformation.DisciplineResponse;
import ru.gb.testback.model.eventInformation.HallInfoResponse;
import ru.gb.testback.model.eventInformation.TrainerResponse;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionFullInfoResponse {

    private TrainerResponse trainer;
    private DisciplineResponse discipline;
    private Long id;
    private String image;
    private BigDecimal price;
    private String duration;
    private String comment;
}
