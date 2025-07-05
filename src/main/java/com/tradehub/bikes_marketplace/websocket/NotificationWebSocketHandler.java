package com.tradehub.bikes_marketplace.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

@Component
public class NotificationWebSocketHandler extends TextWebSocketHandler {

    private Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        // Add session to the set when a new WebSocket connection is made
        sessions.add(session);
        System.out.println("New WebSocket connection established");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        // Handle incoming messages (if any). This could be subscription requests or general messages
        System.out.println("Recevied message: "+ message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        // Remove session from the set when the connection is closed
        sessions.remove(session);
        System.out.println("WebSocket Connection Closed");
    }

    public void broadcastNotification(String message){
        for(WebSocketSession session : sessions){
            try{
                session.sendMessage(new TextMessage(message));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
