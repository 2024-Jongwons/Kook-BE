package com.example.kook.domain.comment.domain.repository;

import com.example.kook.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
