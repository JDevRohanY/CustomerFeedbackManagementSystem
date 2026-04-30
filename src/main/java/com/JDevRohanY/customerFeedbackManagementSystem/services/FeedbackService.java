package com.JDevRohanY.customerFeedbackManagementSystem.services;

import com.JDevRohanY.customerFeedbackManagementSystem.models.Feedback;

public interface FeedbackService {

    Feedback createFeedback(String customerId, String agentId, int rating);

    Feedback updateFeedback(String id);
}
