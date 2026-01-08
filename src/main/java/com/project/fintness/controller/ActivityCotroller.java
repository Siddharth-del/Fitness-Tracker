package com.project.fintness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fintness.dto.ActivityRequest;
import com.project.fintness.dto.ActivityResponse;
import com.project.fintness.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
public class ActivityCotroller {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
            ActivityResponse activities=activityService.trackActivity(request);
            return ResponseEntity.ok(activities);
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivity(@RequestHeader(value = "X-User-ID") String userId ){
      return ResponseEntity.ok(activityService.getUserActivity(userId));
    }
}
