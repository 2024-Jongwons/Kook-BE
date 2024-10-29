package com.example.kook.domain.post.presentation.dto.response;

import com.example.kook.domain.comment.presentation.dto.response.CommentResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String userId;
    private final String profileImage;
    private final String videoPath;
    private final Integer heartCounts;
    private final Integer commentCounts;
    private final List<CommentResponse> comments;

    @Builder
    public PostResponse(Long id, String title, String userId, String profileImage, String videoPath, Integer heartCounts, Integer commentCounts) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.profileImage = profileImage;
        this.videoPath = videoPath;
        this.heartCounts = heartCounts;
        this.commentCounts = commentCounts;
    }
}
