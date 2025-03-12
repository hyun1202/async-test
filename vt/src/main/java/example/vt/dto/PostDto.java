package example.vt.dto;

import example.vt.Post;

import java.time.LocalDateTime;

public record PostDto(
        Long id,
        String title,
        String body,
        LocalDateTime createdAt
) {
    public PostDto(Post post) {
        this(post.getId(), post.getTitle(), post.getBody(), post.getCreatedAt());
    }
}
