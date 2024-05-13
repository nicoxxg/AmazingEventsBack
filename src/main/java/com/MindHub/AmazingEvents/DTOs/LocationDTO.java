package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.EventLocation;
import com.MindHub.AmazingEvents.Models.Location;
import jakarta.persistence.Column;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
public class LocationDTO {
    private UUID id;
    private String name;
    private String location;
    private int capacity;
    private String img;
    private Set<EventLocationDTO> eventLocations;

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.location = location.getLocation();
        this.capacity = location.getCapacity();
        this.img = location.getImg();
        this.eventLocations = location.getEventLocations().stream().map(eventLocation -> new EventLocationDTO(eventLocation)).collect(Collectors.toSet());
    }

}
