package com.project.fintness.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fintness.dto.RecommendationRequest;
import com.project.fintness.model.Activity;
import com.project.fintness.model.Recommendation;
import com.project.fintness.model.User;
import com.project.fintness.repository.ActivityRepository;
import com.project.fintness.repository.RecommendationRepository;
import com.project.fintness.repository.UserRepository;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;
    public Recommendation generateRecommendation(RecommendationRequest request) {
          User user=userRepository.findById(request.getUserId())
          .orElseThrow(()->new RuntimeException("User Not Found: "+request.getUserId()));

          Activity activity=activityRepository.findById(request.getActivityId())
          .orElseThrow(()->new RuntimeException("Activity Not found: "+request.getActivityId()));

          Recommendation recommendation =Recommendation.builder()
          .user(user)
          .activity(activity)
          .improvements(request.getImprovements())
          .suggestions(request.getSuggestions())
          .safety(request.getSafety())
          .build();

          Recommendation savedRecommendation=recommendationRepository.save(recommendation);
          return savedRecommendation;
    }

    public List<Recommendation> getUserRecommendation(String userId){
        List<Recommendation> userRecommendations=recommendationRepository.findByUserId(userId);
        return userRecommendations;
    }

    public List<Recommendation> getActivityRecommendation(String activityId){
        List<Recommendation> activityRecommendations=recommendationRepository.findByActivityId(activityId);
        return activityRecommendations;

    }

    
}
