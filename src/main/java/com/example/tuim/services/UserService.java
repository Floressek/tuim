package com.example.tuim.services;

import com.example.tuim.data.dtos.UserRequest;
import com.example.tuim.data.dtos.UserResponse;
import com.example.tuim.data.entities.User;
import com.example.tuim.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserRequest userRequest) {
        var user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        userRepository.save(user);
    }

    public List<UserResponse> getAll() {
       return userRepository.findAll().stream()
               .map(x -> new UserResponse(
                       x.getId(),
                       x.getName(),
                       x.getSurname()
               ))
               .toList();

    }

    public void getByName(){
        User user = userRepository.findByName("Kamil");
        System.out.println(user.getSurname());
    }
}
