package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.CustomerEvent;
import com.MindHub.AmazingEvents.Models.EventLocation;
import lombok.Getter;

import java.util.UUID;
@Getter
public class CustomerEventDTO {
    private UUID id;
    private EventLocation eventLocation;

    public CustomerEventDTO(CustomerEvent customerEvent) {
        this.id = customerEvent.getId();
        this.eventLocation = customerEvent.getEventLocation();
    }

}
