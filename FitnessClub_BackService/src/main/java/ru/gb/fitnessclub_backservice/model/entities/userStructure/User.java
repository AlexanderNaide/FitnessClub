package ru.gb.fitnessclub_backservice.model.entities.userStructure;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.gb.fitnessclub_backservice.model.entities.classStructure.Workout;
import ru.gb.fitnessclub_backservice.model.entities.clubStructure.UserSubscription;
import ru.gb.fitnessclub_backservice.model.enums.Gender;
import ru.gb.fitnessclub_backservice.model.enums.Role;
import ru.gb.fitnessclub_backservice.model.enums.Specialization;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Unsigned
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "role")
    private Role role;

    @Column(name = "specialization")
    private Specialization specialization;

    @OneToMany(mappedBy = "user")
    @JsonBackReference(value = "UserSubscription") // без этой аннотации jackson тянет все объекты по цепочки, аналог lazyInitialization
    private List<UserSubscription> subscriptionList;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "background")
    private String background;

    @OneToMany(mappedBy = "trainer")
    @JsonBackReference(value = "Workout") // без этой аннотации jackson тянет все объекты по цепочки, аналог lazyInitialization
    private List<Workout> workouts;

}

