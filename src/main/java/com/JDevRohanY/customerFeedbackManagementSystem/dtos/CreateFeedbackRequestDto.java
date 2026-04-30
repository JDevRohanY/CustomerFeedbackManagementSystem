package com.JDevRohanY.customerFeedbackManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateFeedbackRequestDto {
    String customerId;
    String agentId;
    int rating;
}
