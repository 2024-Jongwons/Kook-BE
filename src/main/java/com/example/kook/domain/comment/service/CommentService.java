package com.example.kook.domain.comment.service;

import com.example.kook.domain.comment.domain.Comment;
import com.example.kook.domain.comment.domain.repository.CommentRepository;
import com.example.kook.domain.comment.exception.CommentNotFoundException;
import com.example.kook.domain.comment.presentation.dto.request.CommentRequest;
import com.example.kook.domain.post.domain.Post;
import com.example.kook.domain.post.domain.repository.PostRepository;
import com.example.kook.domain.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long creat(CommentRequest request) {
        Post post = postRepository.findById(request.getId())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        return commentRepository.save(Comment.builder()
                .post(post)
                .userId(request.getUserId())
                .content(request.getContent())
                .build()).getId();

    }
}

