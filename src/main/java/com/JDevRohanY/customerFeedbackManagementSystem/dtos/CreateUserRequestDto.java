package com.JDevRohanY.customerFeedbackManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    String name;
    String email;
    String role;
}
