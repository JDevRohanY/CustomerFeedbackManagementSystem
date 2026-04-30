package com.JDevRohanY.customerFeedbackManagementSystem.controllers;

import com.JDevRohanY.customerFeedbackManagementSystem.dtos.CreateFeedbackRequestDto;
import com.JDevRohanY.customerFeedbackManagementSystem.dtos.CreateFeedbackResponseDto;
import com.JDevRohanY.customerFeedbackManagementSystem.models.Feedback;
import com.JDevRohanY.customerFeedbackManagementSystem.services.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<CreateFeedbackResponseDto> createFeedback(@RequestBody CreateFeedbackRequestDto requestDto) {
        String customerId = requestDto.getCustomerId();
        String agentId = requestDto.getAgentId();
        int rating = requestDto.getRating();

        //call the service class
        Feedback feedback = feedbackService.createFeedback(customerId, agentId, rating);
        CreateFeedbackResponseDto responseDto = new CreateFeedbackResponseDto();
        responseDto.setFeedbackId(feedback.getId());
        responseDto.setCreatedAt(feedback.getCreatedAt());
        responseDto.setCustomerId(feedback.getCustomerId());
        responseDto.setStatus(feedback.getStatus().toString());
        responseDto.setRating(feedback.getRating());
        responseDto.setAgentId(feedback.getAgentId());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PatchMapping("feedbacks/{id}/review")
    public ResponseEntity<String> updateFeedbackStatus(@PathVariable String id) {
        Feedback feedback = feedbackService.updateFeedback(id);
        return ResponseEntity.status(HttpStatus.OK).body("Feedback with Id : " + feedback.getId() + ", updated to reviewed");
    }

}
