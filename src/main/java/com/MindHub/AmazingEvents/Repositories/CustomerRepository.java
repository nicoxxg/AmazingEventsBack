package com.MindHub.AmazingEvents.Repositories;

import com.MindHub.AmazingEvents.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer , UUID> {
    Customer findByEmail(String email);
}
