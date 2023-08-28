package ru.gb.fitnessclub_backservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.fitnessclub_backservice.model.entities.User;
import ru.gb.fitnessclub_backservice.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findUserByUsername(String name){
        return userRepository.findByUsername(name);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
