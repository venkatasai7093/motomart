package com.tradehub.bikes_marketplace.model;

import com.tradehub.bikes_marketplace.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String profilePictureUrl;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            Random random = new Random();
            this.id = (long)(10000 + random.nextInt(90000));  // Generate 5-digit ID as Long
        }
    }
}
