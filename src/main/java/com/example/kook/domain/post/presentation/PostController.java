package com.example.kook.domain.post.presentation;

import com.example.kook.domain.post.presentation.dto.request.PostRequest;
import com.example.kook.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(
            @RequestParam("title") String title,
            @RequestParam("userId") String userId,
            @RequestParam("profileImage") String profileImage,
            @RequestParam("video") MultipartFile video,
            @RequestParam("tags") List<String> tags) {

        PostRequest postRequest = new PostRequest();
        postRequest.setTitle(title);
        postRequest.setUserId(userId);
        postRequest.setProfileImage(profileImage);
        postRequest.setVideo(video);
        postRequest.setTags(tags);

        return ResponseEntity.ok(postService.createPost(postRequest));
    } //악더러워
}