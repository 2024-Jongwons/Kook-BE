package com.example.kook.domain.post.service;

import com.example.kook.domain.post.domain.Post;
import com.example.kook.domain.post.domain.Tag;
import com.example.kook.domain.post.domain.repository.PostRepository;
import com.example.kook.domain.post.presentation.dto.request.PostRequest;
import com.example.kook.global.aws.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final TagService tagService;
    private final S3Util s3Util;

    @Transactional
    public Post createPost(PostRequest postRequest) {
        String videoPath = s3Util.upload(postRequest.getVideo());

        Set<Tag> tags = postRequest.getTags().stream()
                .map(tagName -> tagService.createOrGetTag(tagName))
                .collect(Collectors.toSet());

        Post post = Post.builder()
                .title(postRequest.getTitle())
                .userId(postRequest.getUserId())
                .profileImage(postRequest.getProfileImage())
                .videoPath(s3Util.getVideoUrl(videoPath))
                .tags(tags)
                .build();

        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}