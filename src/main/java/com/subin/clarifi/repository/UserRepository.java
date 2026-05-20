package com.subin.clarifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.subin.clarifi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
