package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.EventDTO;
import com.MindHub.AmazingEvents.Repositories.EventRepository;
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
public class EventController {
    @Autowired
    public EventRepository eventRepository;

    @GetMapping("/event")
    public List<EventDTO> getEvents(){
        return eventRepository.findAll().stream().map(event -> new EventDTO(event)).collect(Collectors.toList());
    }
    @GetMapping("/event/{id}")
    public EventDTO getEventById(@PathVariable UUID id){
        return new EventDTO(eventRepository.findById(id).orElse(null));
    }
}
