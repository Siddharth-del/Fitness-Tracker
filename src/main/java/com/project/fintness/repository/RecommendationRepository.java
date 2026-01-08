package com.project.fintness.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fintness.model.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,String> {

    List<Recommendation> findByUserId(String userId);

    List<Recommendation> findByActivityId(String activityId);

}
