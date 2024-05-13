package com.MindHub.AmazingEvents.Repositories;

import com.MindHub.AmazingEvents.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
