package com.MindHub.AmazingEvents.Models;

import com.MindHub.AmazingEvents.Models.Enums.Genders;
import com.MindHub.AmazingEvents.Models.Enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @Setter(AccessLevel.NONE)
    private UUID customerId;
    private String name;
    private String lastName;
    private boolean activated;
    private String email;
    private String password;
    private int years;
    private Rol rol;
    private Genders gender;
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<LikeEvent> LikeEvents = new HashSet<>();

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    public Customer(UUID customerId, String name, String lastName, boolean activated,String email, String password, int years, Genders gender,Rol rol) {
        this.customerId = customerId;
        this.name = name;
        this.lastName = lastName;
        this.activated = activated;
        this.email = email;
        this.password = password;
        this.years = years;
        this.gender = gender;
        this.rol = rol;
    }
}
