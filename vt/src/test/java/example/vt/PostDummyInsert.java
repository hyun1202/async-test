package example.vt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostDummyInsert {
    @Autowired PostRepository postRepository;

    @Test
    void test() {
        for (int i=0; i<1000; i++) {
            String title = "test title";
            String body = "test body";
            Post post = new Post(title, body);
            postRepository.save(post);
        }
    }
}
