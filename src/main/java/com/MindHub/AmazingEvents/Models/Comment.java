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
public class Comment {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name_id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;
    @Column(length = 2000)
    private String comment;
    private int calification;

    public Comment(UUID id, Customer customer, Event event, String comment, int calification) {
        this.id = id;
        this.customer = customer;
        this.event = event;
        this.comment = comment;
        this.calification = calification;
    }
}
