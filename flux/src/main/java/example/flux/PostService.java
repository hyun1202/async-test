package example.flux;

import example.flux.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Flux<PostDto> getPost() {
        return postRepository.findAll()
                .map(PostDto::new);
    }

    public Mono<List<PostDto>> getPostToMono() {
        return postRepository.findAll()
                .map(PostDto::new)
                .collectList();
    }

    public Mono<Long> savePost(PostDto req) {
        Post post = new Post(req.title(), req.body());
        return postRepository.save(post).map(Post::getId);
    }
}
