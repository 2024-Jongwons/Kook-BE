package com.example.kook.domain.post.service;

import com.example.kook.domain.post.domain.Post;
import com.example.kook.domain.post.domain.Tag;
import com.example.kook.domain.post.domain.repository.PostRepository;
import com.example.kook.domain.post.exception.PostNotFoundException;
import com.example.kook.domain.post.presentation.dto.request.PostRequest;
import com.example.kook.domain.post.presentation.dto.response.PostListResponse;
import com.example.kook.global.aws.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<Post> getPostsByTagName(String tagName) {
        return postRepository.findByTags_Name(tagName);
    }

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> findPost(String title) {
        return postRepository.findAllByTitleContaining(title);
    }

    @Transactional
    public Integer addHeartToPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다: " + postId));

        return post.addHeartCount();
    }

    @Transactional(readOnly = true)
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다: " + postId));
    }

    @Transactional(readOnly = true)
    public List<Post> findPostsByTagNames(Set<String> tagNames) {
        return postRepository.findByTags_Names(tagNames);
    }
}