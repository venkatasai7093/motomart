package com.tradehub.bikes_marketplace.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradehub.bikes_marketplace.dto.NotificationMessage;
import com.tradehub.bikes_marketplace.websocket.RedisMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NotificationController {

    private final RedisMessagePublisher redisPublisher;

    @MessageMapping("/notify")// Client sends to /app/notify
    public void notifyCategory(NotificationMessage message) throws JsonProcessingException {
        // Message should contain category and content
        redisPublisher.publish(new ObjectMapper().writeValueAsString(message));
    }
}
