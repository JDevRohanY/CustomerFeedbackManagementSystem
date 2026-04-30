package com.JDevRohanY.customerFeedbackManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUserResponseDto {
    String id;
    String name;
    String email;
    String role;
    Date createdAt;
}
