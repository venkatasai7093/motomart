package com.tradehub.bikes_marketplace.dto;

import lombok.Data;

@Data
public class NotificationMessage {
    private String category; // e.g., "mountain"
    private String message;  // actual notification content
}
