package com.example.kook.domain.post.domain.repository;

import com.example.kook.domain.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByIdDesc();
    List<Post> findByTags_Name(String tagName);

    List<Post> findAllByTitleContaining(String title);
}
