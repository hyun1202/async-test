package example.vt;

import example.vt.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDto> getPost() {
        return postRepository.findAll().stream()
                .map(PostDto::new).toList();
    }

    public Long savePost(PostDto req) {
        Post post = new Post(req.title(), req.body());
        return postRepository.save(post).getId();
    }
}
