package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.CustomerEvent;
import com.MindHub.AmazingEvents.Models.Event;
import com.MindHub.AmazingEvents.Models.EventLocation;
import com.MindHub.AmazingEvents.Models.Location;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
public class EventLocationDTO {
    private UUID id;
    private Date date;
    private int assistance;
    private Set<CustomerEventDTO> customerEvents;

    public EventLocationDTO(EventLocation eventLocation) {
        this.id = eventLocation.getId();
        this.date = eventLocation.getDate();
        this.assistance = eventLocation.getAssistance();
        this.customerEvents = eventLocation.getCustomerEvents().stream().map(customerEvent -> new CustomerEventDTO(customerEvent)).collect(Collectors.toSet());
    }

}
