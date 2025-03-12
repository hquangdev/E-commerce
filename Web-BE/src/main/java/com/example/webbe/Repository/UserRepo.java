package com.example.webbe.Repository;

import com.example.webbe.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByName(String name);

    Optional<User> findByName(String name);

}
