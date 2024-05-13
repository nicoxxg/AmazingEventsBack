package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.LikeEvent;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;
@Getter
public class LikeEventDTO {
    private UUID id;
    private UUID eventId;
    private String eventName;
    private String description;

    public LikeEventDTO(LikeEvent likeEvent) {
        this.id = likeEvent.getId();
        this.eventId = likeEvent.getEvent().getEventId();
        this.eventName = likeEvent.getEvent().getName();
        this.description = likeEvent.getEvent().getDescription();
    }


}
