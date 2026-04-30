package com.JDevRohanY.customerFeedbackManagementSystem.services;

import com.JDevRohanY.customerFeedbackManagementSystem.exceptions.FeedbackNotFoundException;
import com.JDevRohanY.customerFeedbackManagementSystem.exceptions.UserNotFoundException;
import com.JDevRohanY.customerFeedbackManagementSystem.models.Feedback;
import com.JDevRohanY.customerFeedbackManagementSystem.models.FeedbackStatus;
import com.JDevRohanY.customerFeedbackManagementSystem.models.User;
import com.JDevRohanY.customerFeedbackManagementSystem.repositories.FeedbackRepository;
import com.JDevRohanY.customerFeedbackManagementSystem.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class FeedbackServiceImpl implements FeedbackService{
    private final UserRepository userRepository;
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(UserRepository userRepository, FeedbackRepository feedbackRepository) {
        this.userRepository = userRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback createFeedback(String customerId, String agentId, int rating) {
        log.info("Creating new Feedback");
        //check whether the agentId exist or not
        Optional<User> user = userRepository.getUser(agentId);
        if(user.isEmpty()){
            log.warn("User with Id : {} not exist", agentId);
            throw new UserNotFoundException("Agent with Id : " + agentId + " not found.");
        }
        log.info("User found, checking the score (1-5)");

        //Check the rating
        if(rating<1 || rating >5){
            log.warn("Rating is not under the limit, please correct rating. Given rating : {}", rating);
            throw new IllegalArgumentException("Rating should be between 1 to 5");
        }

        log.info("Rating is correct, creating feedback");
        Feedback feedback = new Feedback();
        feedback.setId(UUID.randomUUID().toString());
        feedback.setCreatedAt(new Date());
        feedback.setAgentId(agentId);
        feedback.setComment("");
        feedback.setCustomerId(customerId);
        feedback.setRating(rating);
        //by default
        feedback.setStatus(FeedbackStatus.PENDING);

        feedbackRepository.addFeedback(feedback.getId(), feedback);
        log.info("Feedback is created with id : {}", feedback.getId());
        return feedback;
    }

    @Override
    public Feedback updateFeedback(String feedbackId) {
        //Check the feedback exist or not
        Optional<Feedback> feedback = feedbackRepository.getFeedback(feedbackId);
        if(feedback.isEmpty()){
            log.warn("Feedback not found with Feedback id : {}", feedbackId);
            throw new FeedbackNotFoundException("Feedback not found with feedbackId : " + feedbackId);
        }
        feedback = Optional.ofNullable(feedbackRepository.updateFeedbackStatus(feedbackId));
        return feedback.get();
    }
}
