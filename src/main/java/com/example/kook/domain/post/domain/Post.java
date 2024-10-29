package com.example.kook.domain.post.domain;

import com.example.kook.domain.comment.domain.Comment;
import com.example.kook.domain.post.domain.tags.tagsEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String userId;

    private String profileImage;

    private String videoPath;

    private Integer heartCount = 0;

    private Integer commentCount = 0;

    @ElementCollection(targetClass = tagsEnum.class)
    @Enumerated(EnumType.STRING)
    private Set<tagsEnum> tags;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(String title, String profileImage, String userId, String videoPath) {
        this.title = title;
        this.profileImage = profileImage;
        this.userId = userId;
        this.videoPath = videoPath;
    }


    public int getCommentCount() {
        return comments.size();
    }
}