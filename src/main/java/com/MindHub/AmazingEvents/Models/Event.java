package com.MindHub.AmazingEvents.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID eventId;
    private String name;
    @Column(length = 1000)
    private String description;
    @Column(length = 2000)
    private String img;
    private int ageRequerided;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
    private Set<LikeEvent> LikeEvents = new HashSet<>();
    @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();
    @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
    private Set<EventLocation> eventLocations = new HashSet<>();


    public Event(UUID eventId, String name, String description, String img, int ageRequerided, Customer customer) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.img = img;
        this.ageRequerided = ageRequerided;
        this.customer = customer;
    }
}
