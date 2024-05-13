package com.MindHub.AmazingEvents.Controllers;

import com.MindHub.AmazingEvents.DTOs.CommentDTO;
import com.MindHub.AmazingEvents.Models.Comment;
import com.MindHub.AmazingEvents.Models.Event;
import com.MindHub.AmazingEvents.Repositories.CommentRepository;
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
public class CommentController {
    @Autowired
    public CommentRepository commentRepository;
    @Autowired
    public EventRepository eventRepository;

    @GetMapping("/comment")
    public List<CommentDTO> getComments(){
        return commentRepository.findAll().stream().map(comment -> new CommentDTO(comment)).collect(Collectors.toList());
    }

    @GetMapping("/comment/{id}")
    public CommentDTO getCommentById(@PathVariable UUID id){
        return new CommentDTO(commentRepository.findById(id).orElse(null));
    }

    @GetMapping("/event/{id}/comment")
    public List<CommentDTO> geteventComments(@PathVariable UUID id){
        Event event = eventRepository.findById(id).orElse(null);

        return event.getComments().stream().map(comment -> new CommentDTO(comment)).collect(Collectors.toList());

    }
}
