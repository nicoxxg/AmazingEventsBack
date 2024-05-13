package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.EventLocationDTO;
import com.MindHub.AmazingEvents.Repositories.EventLocationRepository;
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
public class EventLocationController {
    @Autowired
    public EventLocationRepository eventLocationRepository;

    @GetMapping("/eventLocation")
    public List<EventLocationDTO> getEventLocation(){
        return eventLocationRepository.findAll().stream().map(eventLocation -> new EventLocationDTO(eventLocation)).collect(Collectors.toList());
    }
    @GetMapping("/eventLocation/{id}")
    public EventLocationDTO getEventLocationById(@PathVariable UUID id){
        return new EventLocationDTO(eventLocationRepository.findById(id).orElse(null));
    }


}
