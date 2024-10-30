package com.example.kook.domain.comment.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentRequest {
    @NotNull
    private Long id;

    @Size(min = 5, max = 5000)
    private String content;

    private String userId;
}
