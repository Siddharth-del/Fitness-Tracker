package com.project.fintness.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fintness.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findById(String userId);

    User findByEmail(String email);

   

}
