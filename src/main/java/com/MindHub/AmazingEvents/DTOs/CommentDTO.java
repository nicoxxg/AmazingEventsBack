package com.MindHub.AmazingEvents.DTOs;

import com.MindHub.AmazingEvents.Models.Comment;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CommentDTO {
    private UUID commentId;
    private UUID eventId;
    private UUID customerId;
    private String comment;
    private int calification;

    public CommentDTO(Comment comment) {
        this.commentId = comment.getId();
        this.eventId = comment.getEvent().getEventId();
        this.customerId = comment.getCustomer().getCustomerId();
        this.comment = comment.getComment();
        this.calification = comment.getCalification();
    }

}
