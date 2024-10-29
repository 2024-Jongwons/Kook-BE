package com.example.kook.domain.post.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class PostRequest {
    private String title;
    private String userId;
    private String profileImage;
    private MultipartFile video;
    private List<String> tags;
}