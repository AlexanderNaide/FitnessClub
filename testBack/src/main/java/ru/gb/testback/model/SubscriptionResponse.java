package ru.gb.testback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private Long id;
    private String discipline;
    private Integer workoutCount;
    private Integer daysToExpire;
    private BigDecimal price;
}
