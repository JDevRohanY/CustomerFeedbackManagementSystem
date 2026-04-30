package com.JDevRohanY.customerFeedbackManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel{
    String name;
    String email;
    UserRole role;
}
