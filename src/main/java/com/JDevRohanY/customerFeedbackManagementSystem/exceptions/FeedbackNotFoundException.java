package com.JDevRohanY.customerFeedbackManagementSystem.exceptions;

public class FeedbackNotFoundException extends RuntimeException{
    public FeedbackNotFoundException(String message){
        super(message);
    }
}
