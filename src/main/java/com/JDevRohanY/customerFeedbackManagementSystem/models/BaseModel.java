package com.JDevRohanY.customerFeedbackManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    String id;
    Date createdAt;
    Date updatedAt;
}
