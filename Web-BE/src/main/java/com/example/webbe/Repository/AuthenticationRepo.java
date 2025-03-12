package com.example.webbe.Repository;

import com.example.webbe.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthenticationRepo extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);
}
