package ru.gb.fitnessclub_backservice.model.entities.classStructure;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.fitnessclub_backservice.model.entities.userStructure.User;
import ru.gb.fitnessclub_backservice.model.enums.Specialization;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "workouts")
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Unsigned
    private Long id;

    @Column(name = "is_group")
    private boolean isGroup;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    @Unsigned
    private User trainer;

    @Column(name = "specialization")
    private Specialization category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "workout_count")
    private int workoutCount;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    @Column(name = "duration")
    private int duration;


/*    @ManyToMany
    @JoinTable(name = "user_classes",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> customers;*/

/*    @Column(name = "time")
    private LocalDateTime time;*/



}
