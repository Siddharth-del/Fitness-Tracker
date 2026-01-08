package com.project.fintness.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fintness.model.Activity;
import com.project.fintness.model.User;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,String>{

    List<Activity> findByUserId(String userId);

    

    
}
