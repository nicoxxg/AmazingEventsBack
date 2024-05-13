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
public class LikeEvent {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name_id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;

    public LikeEvent(UUID id, Customer customer, Event event) {
        this.id = id;
        this.customer = customer;
        this.event = event;
    }
}
