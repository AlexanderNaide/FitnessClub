package ru.gb.testback;

import org.springframework.web.bind.annotation.*;
import ru.gb.testback.model.AuthRequest;
import ru.gb.testback.model.AuthResponse;
import ru.gb.testback.model.TicketDto;
import ru.gb.testback.model.UserDto;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class TestController {

    @PostMapping("/auth")
    public AuthResponse token(@RequestBody AuthRequest request){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTY4OTkzODgwNCwiaWF0IjoxNjg4NzI5MjA0LCJhdXRob3JpdHkiOlsidXNlciJdfQ.bJCA6uPS9Amz58Ykq9yfOwf7CzE5v5FmjsHd14eJyqw";
        return new AuthResponse(token);
    }

    @PostMapping("/reg")
    public AuthResponse reg(@RequestBody AuthRequest request){
        System.out.println(request.getKeypass());
        System.out.println(request.getPassword());

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTY4OTkzODgwNCwiaWF0IjoxNjg4NzI5MjA0LCJhdXRob3JpdHkiOlsidXNlciJdfQ.bJCA6uPS9Amz58Ykq9yfOwf7CzE5v5FmjsHd14eJyqw";
        return new AuthResponse(token);
    }

    @GetMapping("/info")
    public UserDto info(){
        return new UserDto();
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto userDto){
        System.out.println("\nПришло:");
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getKeypass());
        System.out.println(userDto.getPhone());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
    }

    @GetMapping("/tickets")
    public List<TicketDto> tickets(){
        return List.of(new TicketDto());
    }

    @GetMapping("/ticket/{id}")
    public void getOrderById(@PathVariable Long id){
        System.out.println(id);
    }



}
