package com.JDevRohanY.customerFeedbackManagementSystem.services;

import com.JDevRohanY.customerFeedbackManagementSystem.models.User;

public interface UserService {
    User createUser(String name, String email, String role);
}
