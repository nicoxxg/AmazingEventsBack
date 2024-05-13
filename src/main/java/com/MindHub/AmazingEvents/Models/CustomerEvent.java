package com.MindHub.AmazingEvents.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerEvent {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private EventLocation eventLocation;

    public CustomerEvent(UUID id, Customer customer, EventLocation eventLocation) {
        this.id = id;
        this.customer = customer;
        this.eventLocation = eventLocation;
    }
}
