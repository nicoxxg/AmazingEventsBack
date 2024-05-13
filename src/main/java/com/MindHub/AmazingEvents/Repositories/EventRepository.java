package com.MindHub.AmazingEvents.Repositories;

import com.MindHub.AmazingEvents.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, UUID> {
}
