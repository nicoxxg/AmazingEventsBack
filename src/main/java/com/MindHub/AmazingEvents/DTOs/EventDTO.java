package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.*;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
public class EventDTO {
    private UUID eventId;
    private String name;
    private String description;
    private String img;
    private int ageRequerided;
    private long likeEvents;
    private Set<CommentDTO> comments = new HashSet<>();
    private Set<EventLocationDTO> eventLocations = new HashSet<>();

    public EventDTO(Event event) {
        this.eventId = event.getEventId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.img = event.getImg();
        this.ageRequerided = event.getAgeRequerided();
        this.likeEvents = event.getLikeEvents().stream().count();
        this.comments = event.getComments().stream().map(comment -> new CommentDTO(comment)).collect(Collectors.toSet());
    }

}
