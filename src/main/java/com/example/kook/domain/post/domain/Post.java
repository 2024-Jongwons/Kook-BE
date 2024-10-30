package com.example.kook.domain.post.domain;

import com.example.kook.domain.comment.domain.Comment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Builder
    public Post(String title, String profileImage, String userId, String videoPath, Set<Tag> tags) {
        this.title = title;
        this.profileImage = profileImage;
        this.userId = userId;
        this.videoPath = videoPath;
        this.tags = tags != null ? tags : new HashSet<>();
    }

    public int getCommentCount() {
        return comments != null ? comments.size() : 0; //0으로 반환 안해줬더니 널값이라 에러나는거 진짜 넘 서운함
    }

    public int addHeartCount(){
        this.heartCount += 1;
        return this.heartCount;
    }
}