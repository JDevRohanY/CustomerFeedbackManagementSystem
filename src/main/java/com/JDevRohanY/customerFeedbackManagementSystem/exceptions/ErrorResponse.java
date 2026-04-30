package com.JDevRohanY.customerFeedbackManagementSystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    String message;
    int code;
}
