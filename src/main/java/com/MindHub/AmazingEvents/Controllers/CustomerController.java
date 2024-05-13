package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.CustomerDTO;
import com.MindHub.AmazingEvents.Models.Customer;
import com.MindHub.AmazingEvents.Models.Enums.Genders;
import com.MindHub.AmazingEvents.Models.Enums.Rol;
import com.MindHub.AmazingEvents.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    public CustomerRepository customerRepository;
    @GetMapping("/customer")
    public List<CustomerDTO> getCustomer(){
        return customerRepository.findAll().stream().map(customer -> new CustomerDTO(customer)).collect(Collectors.toList());
    }
    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerById(@PathVariable UUID id){
        return new CustomerDTO(customerRepository.findById(id).orElse(null));
    }
    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestParam String name,
                                                 @RequestParam String lastName,
                                                 @RequestParam String email,
                                                 @RequestParam String password,
                                                 @RequestParam int age,
                                                 @RequestParam Genders gender,
                                                 @RequestParam Rol rol){
        Customer customer = customerRepository.findByEmail(email);
        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || age == 0 || gender == null || rol == null) {
            return new ResponseEntity<>("param is empty", HttpStatus.FORBIDDEN);
        }
        if (customer == null) {
            return new ResponseEntity<>("email is already used", HttpStatus.FORBIDDEN);
        }
        UUID customerId = UUID.randomUUID();
        while (customerRepository.existsById(customerId)) {
            customerId = UUID.randomUUID();
        }
        Customer newCostumer = new Customer(customerId, name, lastName, true,email, password, age, gender, rol);

        customerRepository.save(newCostumer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
