package com.MindHub.AmazingEvents.Repositories;

import com.MindHub.AmazingEvents.Models.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface CustomerEventRepository extends JpaRepository<CustomerEvent, UUID> {
}
