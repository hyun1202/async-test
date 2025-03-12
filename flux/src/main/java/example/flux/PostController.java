package example.flux;

import example.flux.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public Flux<PostDto> getPost() {
        return postService.getPost();
    }

    @GetMapping("/mono")
    public Mono<List<PostDto>> getPostToMono() {
        return postService.getPostToMono();
    }

    @PostMapping
    public Mono<Long> savePost(@RequestBody PostDto req) {
        return postService.savePost(req);
    }
}
