package com.example.kook.domain.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponse {

    private final Long id;
    private final String userId;
    private final String content;

    @Builder
    public CommentResponse(Long id, String userId, String profileImage, String content, String createDate) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }

}
