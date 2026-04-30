package com.JDevRohanY.customerFeedbackManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback extends BaseModel{
    String customerId;
    String agentId;
    int rating;
    String comment;
    FeedbackStatus status;
}
