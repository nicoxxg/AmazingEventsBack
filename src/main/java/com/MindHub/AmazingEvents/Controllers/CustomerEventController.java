package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.CustomerEventDTO;
import com.MindHub.AmazingEvents.Repositories.CustomerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerEventController {
    @Autowired
    public CustomerEventRepository customerEventRepository;

    @GetMapping("/customerEvent")
    public List<CustomerEventDTO> getCustomerEvents(){
        return customerEventRepository.findAll().stream().map(customerEvent -> new CustomerEventDTO(customerEvent)).collect(Collectors.toList());
    }

    @GetMapping("/customerEvent/{id}")
    public CustomerEventDTO getCustomerEventById(@PathVariable UUID id){
        return new CustomerEventDTO(customerEventRepository.findById(id).orElse(null));
    }
}
