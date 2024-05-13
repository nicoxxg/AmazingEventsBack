package com.MindHub.AmazingEvents.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EventLocation {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    private Date date;
    private int assistance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "eventLocation",fetch = FetchType.EAGER)
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    public EventLocation(UUID id, Date date, int assistance, Event event, Location location) {
        this.id = id;
        this.date = date;
        this.assistance = assistance;
        this.event = event;
        this.location = location;
    }
}
