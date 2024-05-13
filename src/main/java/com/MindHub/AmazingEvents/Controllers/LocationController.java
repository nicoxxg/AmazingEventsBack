package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.LikeEventDTO;
import com.MindHub.AmazingEvents.DTOs.LocationDTO;
import com.MindHub.AmazingEvents.Models.Location;
import com.MindHub.AmazingEvents.Repositories.LocationRepository;
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
public class LocationController {
    @Autowired
    public LocationRepository locationRepository;


    @GetMapping("/location")
    public List<LocationDTO> getLocation(){
        return locationRepository.findAll().stream().map(location -> new LocationDTO(location)).collect(Collectors.toList());
    }
    @GetMapping("/location/{id}")
    public LocationDTO getLocationById(@PathVariable UUID id){
        return new LocationDTO(locationRepository.findById(id).orElse(null));
    }
}
