package com.JDevRohanY.customerFeedbackManagementSystem.repositories;

import com.JDevRohanY.customerFeedbackManagementSystem.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    Map<String, User> userMap = new HashMap<>();
    Set<String> registeredEmail = new HashSet<>();

    //function to check the email is unique
    public boolean isEmailUnique(String email){
        return !registeredEmail.contains(email);
    }

    public void addUser(String id, User user) {
        userMap.put(id, user);
        registeredEmail.add(user.getEmail());
    }

    public Optional<User> getUser(String agentId) {
        return Optional.ofNullable(userMap.get(agentId));
    }
}
