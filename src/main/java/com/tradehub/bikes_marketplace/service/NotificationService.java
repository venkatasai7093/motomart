package com.tradehub.bikes_marketplace.service;

import com.tradehub.bikes_marketplace.model.Bike;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final RedisTemplate<String, String> redisTemplate;

    public NotificationService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void notifyNewBike(Bike bike) {
        String message = "New bike listed: " + bike.getBrand() + " " + bike.getModel();
        redisTemplate.convertAndSend("bikeChannel", message);
    }
}
