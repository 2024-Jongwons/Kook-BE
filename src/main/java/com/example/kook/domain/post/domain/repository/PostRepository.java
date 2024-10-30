package com.example.kook.domain.post.domain.repository;

import com.example.kook.domain.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByIdDesc();
    List<Post> findByTags_Name(String tagName);

    List<Post> findAllByTitleContaining(String title);

    @Query("SELECT p FROM Post p JOIN p.tags t WHERE t.name IN :tagNames GROUP BY p.id")
    List<Post> findByTags_Names(@Param("tagNames") Set<String> tagNames);
}
