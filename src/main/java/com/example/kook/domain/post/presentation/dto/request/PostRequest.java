package com.example.kook.domain.post.presentation.dto.request;

import com.example.kook.domain.post.domain.tags.tagsEnum;
import lombok.Getter;

import java.util.List;

@Getter
public class PostRequest {
    private String title;
    private String userId;
    private String profileImage;
    private String videoPath;
    private List<tagsEnum> tags;
}