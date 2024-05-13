package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.Customer;
import com.MindHub.AmazingEvents.Models.CustomerEvent;
import com.MindHub.AmazingEvents.Models.Enums.Genders;
import com.MindHub.AmazingEvents.Models.Enums.Rol;
import com.MindHub.AmazingEvents.Models.Comment;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
public class CustomerDTO {
    private UUID customerId;
    private String name;
    private String lastName;
    private boolean activated;
    private String email;
    private String password;
    private int years;
    private Rol rol;
    private Genders gender;
    private Set<EventDTO> events = new HashSet<>();
    private Set<LikeEventDTO> likeEvents = new HashSet<>();
    private Set<CommentDTO> comments = new HashSet<>();
    private Set<CustomerEventDTO> customerEvents = new HashSet<>();

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.name = customer.getName();
        this.lastName = customer.getLastName();
        this.activated = customer.isActivated();
        this.email = customer.getEmail();
        this.password = customer.getPassword();
        this.years = customer.getYears();
        this.rol = customer.getRol();
        this.gender = customer.getGender();
        this.events = customer.getEvents().stream().map(event -> new EventDTO(event)).collect(Collectors.toSet());
        this.likeEvents = customer.getLikeEvents().stream().map(likeEvent -> new LikeEventDTO(likeEvent)).collect(Collectors.toSet());
        this.customerEvents = customer.getCustomerEvents().stream().map(customerEvent -> new CustomerEventDTO(customerEvent)).collect(Collectors.toSet());
    }

}
