package com.tradehub.bikes_marketplace.repository;

import com.tradehub.bikes_marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);

    boolean existsByEmail(String email);
}
