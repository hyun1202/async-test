package example.vt;

import example.vt.dto.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @GetMapping("test")
    public String test() {
        log.info("Thread info: {}", Thread.currentThread());
        return "ok";
    }

    @GetMapping
    public List<PostDto> getPost() {
        return postService.getPost();
    }

    @PostMapping
    public Long savePost(@RequestBody PostDto req) {
        return postService.savePost(req);
    }
}
