package com.JDevRohanY.customerFeedbackManagementSystem.services;

import com.JDevRohanY.customerFeedbackManagementSystem.models.User;
import com.JDevRohanY.customerFeedbackManagementSystem.models.UserRole;
import com.JDevRohanY.customerFeedbackManagementSystem.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String email, String role) {
        log.info("Creating new user");
        //Check email id is unique or not
        boolean isUnqiue = userRepository.isEmailUnique(email);
        if (!isUnqiue) {
            log.warn("Entered email is incorrect : {}", email);
            throw new IllegalArgumentException("Please enter unique email");
        }
        //If it is unique
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setEmail(email);
        user.setRole(UserRole.valueOf(role));
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        log.info("Calling to repository class for adding the user");
        userRepository.addUser(user.getId(), user);
        log.info("User created with user id : {}", user.getId());
        return user;
    }
}
