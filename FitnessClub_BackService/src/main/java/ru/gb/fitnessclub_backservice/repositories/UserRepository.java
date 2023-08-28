package ru.gb.fitnessclub_backservice.repositories;

import lombok.Value;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.fitnessclub_backservice.model.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

//    @Query(nativeQuery = true, value = "select * from users where username = ?1")
//    User getUser(String user);
}
