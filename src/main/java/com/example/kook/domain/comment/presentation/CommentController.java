package com.example.kook.domain.comment.presentation;

import com.example.kook.domain.comment.presentation.dto.request.CommentRequest;
import com.example.kook.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Valid CommentRequest request) {
        return commentService.creat(request);
    }

}
