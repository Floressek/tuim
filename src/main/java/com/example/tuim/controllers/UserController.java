package com.example.tuim.controllers;

import com.example.tuim.data.dtos.FactResponse;
import com.example.tuim.data.dtos.UserRequest;
import com.example.tuim.data.dtos.UserResponse;
import com.example.tuim.data.entities.User;
import com.example.tuim.external.apis.CatFactApiClient;
import com.example.tuim.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CatFactApiClient catFactApiClient;

    @Autowired
    public UserController(UserService userService, CatFactApiClient catFactApiClient) {
        this.userService = userService;
        this.catFactApiClient = catFactApiClient;
    }

    @GetMapping("/all")
    public List<UserResponse> getAllUsers () {
        return userService.getAll();
    }

    @PostMapping("/new")
    void addNewUsers (@RequestBody UserRequest userRequest) {
        userService.save(userRequest);
    }

    @GetMapping("/fact")
    public FactResponse getFact () {
        return  catFactApiClient.getFact();
    }

    @GetMapping("/test")
    public void getByName () {
        userService.getByName();
    }



}
