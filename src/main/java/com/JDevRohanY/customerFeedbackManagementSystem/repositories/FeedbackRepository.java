package com.JDevRohanY.customerFeedbackManagementSystem.repositories;

import com.JDevRohanY.customerFeedbackManagementSystem.controllers.FeedbackController;
import com.JDevRohanY.customerFeedbackManagementSystem.models.Feedback;
import com.JDevRohanY.customerFeedbackManagementSystem.models.FeedbackStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class FeedbackRepository {
    Map<String, Feedback> feedbackMap = new HashMap<>();

    public void addFeedback(String id, Feedback feedback){
        feedbackMap.put(id, feedback);
    }

    public Optional<Feedback> getFeedback(String id) {
        return Optional.ofNullable(feedbackMap.get(id));
    }

    public Feedback updateFeedbackStatus(String id){
        Feedback feedback = feedbackMap.get(id);
        feedback.setStatus(FeedbackStatus.REVIEWED);
        feedbackMap.put(id, feedback);
        return feedback;
    }
}
