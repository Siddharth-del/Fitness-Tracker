package com.project.fintness.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {
     private String userId;

     
    private String activityId;

    private String recommendation;

    private List<String> improvements;
    
    private List<String> suggestions;

   
    private List<String> safety;

}
