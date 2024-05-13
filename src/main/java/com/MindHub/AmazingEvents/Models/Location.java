package com.MindHub.AmazingEvents.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String location;
    private int capacity;
    @Column(length = 3000)
    private String img;
    @OneToMany(mappedBy = "location")
    private Set<EventLocation> eventLocations = new HashSet<>();

    public Location(UUID id, String name, String location, int capacity, String img) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.img = img;
    }
}
