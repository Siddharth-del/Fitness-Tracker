package com.project.fintness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fintness.dto.RecommendationRequest;
import com.project.fintness.model.Recommendation;
import com.project.fintness.model.User;
import com.project.fintness.service.RecommendationService;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;
  
    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
        @RequestBody RecommendationRequest request
    ){
         Recommendation recommendation= recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId){
       List<Recommendation> userRecommendation=recommendationService.getUserRecommendation(userId);
       return ResponseEntity.ok(userRecommendation);
    }
    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String activityId){
        List<Recommendation> activityRecommendation=recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(activityRecommendation);
    }
}
