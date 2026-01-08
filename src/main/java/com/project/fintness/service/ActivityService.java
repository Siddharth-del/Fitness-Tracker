package com.project.fintness.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fintness.dto.ActivityRequest;
import com.project.fintness.dto.ActivityResponse;
import com.project.fintness.model.Activity;
import com.project.fintness.model.User;
import com.project.fintness.repository.ActivityRepository;
import com.project.fintness.repository.UserRepository;

@Service
public class ActivityService {
     @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest request){
         User user=userRepository.findById(request.getUserId())
                         .orElseThrow(()-> new RuntimeException("Invalid User: "+ request.getUserId()));

        Activity activity=new Activity().builder()
        .user(user)
        .type(request.getType())
        .caloriesBurned(  request.getCaloriesBurned())
        .duration(request.getDuration())
        .starTime(request.getStarTime())
        .additionalMetrics(request.getAdditionalMetrics())
        .build();

         Activity savedActivity=activityRepository.save(activity);
         return mapToResponse(savedActivity);

    }

    private ActivityResponse mapToResponse(Activity savedActivity){
             ActivityResponse activity=new ActivityResponse();
             activity.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
             activity.setCaloriesBurned(savedActivity.getCaloriesBurned());
             activity.setDuration(savedActivity.getDuration());
             activity.setStarTime(savedActivity.getStarTime());
             activity.setId(savedActivity.getId());
             activity.setUserId(savedActivity.getUser().getId());
             activity.setCreatedAt(savedActivity.getCreatedAt());
             activity.setUpDateAt(savedActivity.getUpDateAt());
             activity.setType(savedActivity.getType());
             return activity;
    }


    public List<ActivityResponse> getUserActivity(String userId){
        List<Activity> activityList=activityRepository.findByUserId(userId);
        return activityList.stream().map(this::mapToResponse).collect(Collectors.toList());
    }


}
