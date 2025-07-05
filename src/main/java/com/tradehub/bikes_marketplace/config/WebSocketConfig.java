package com.tradehub.bikes_marketplace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/notifications")       // same endpoint but STOMP-enabled
                .setAllowedOriginPatterns("*")          // allow all origins or restrict as needed
                .withSockJS();                           // fallback support for browsers
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue"); // enables simple in-memory broker
        registry.setApplicationDestinationPrefixes("/app"); // prefix for sending messages from clients to server
    }
}
