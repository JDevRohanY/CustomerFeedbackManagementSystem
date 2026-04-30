package com.JDevRohanY.customerFeedbackManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowUpAction extends BaseModel{
    String feedbackId;
    String assignedToAgentId;
    String description;
    FollowUpActionStatus status;
}
