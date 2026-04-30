package com.JDevRohanY.customerFeedbackManagementSystem.controllers;

import com.JDevRohanY.customerFeedbackManagementSystem.dtos.CreateUserRequestDto;
import com.JDevRohanY.customerFeedbackManagementSystem.dtos.CreateUserResponseDto;
import com.JDevRohanY.customerFeedbackManagementSystem.models.User;
import com.JDevRohanY.customerFeedbackManagementSystem.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto requestDto){
        String name = requestDto.getName();
        String email = requestDto.getEmail();
        String role = requestDto.getRole();

        //call the user service class
        User user = userService.createUser(name, email, role);
        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setRole(user.getRole().toString());
        responseDto.setName(user.getName());
        responseDto.setEmail(user.getEmail());
        responseDto.setCreatedAt(user.getCreatedAt());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
