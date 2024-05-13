package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.EventLocationDTO;
import com.MindHub.AmazingEvents.DTOs.LikeEventDTO;
import com.MindHub.AmazingEvents.Repositories.LikeEventRepository;
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
public class LikeEventController {
    @Autowired
    public LikeEventRepository likeEventRepository;

    @GetMapping("/likeEvent")
    public List<LikeEventDTO> geLiketEvent(){
        return likeEventRepository.findAll().stream().map(likeEvent -> new LikeEventDTO(likeEvent)).collect(Collectors.toList());
    }
    @GetMapping("/likeEvent/{id}")
    public LikeEventDTO getlikeEventById(@PathVariable UUID id){
        return new LikeEventDTO(likeEventRepository.findById(id).orElse(null));
    }
}
