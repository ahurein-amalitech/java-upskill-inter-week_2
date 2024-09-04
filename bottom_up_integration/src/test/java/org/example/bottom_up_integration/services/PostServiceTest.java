package org.example.bottom_up_integration.services;

import org.example.bottom_up_integration.entities.Post;
import org.example.bottom_up_integration.entities.User;
import org.example.bottom_up_integration.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;


    @Test
    void testCreatePost() {
        Post post = new Post("Post one", LocalDateTime.now(), new User("Ahurein", "ahurein@gmail.com"));
        when(postRepository.save(ArgumentMatchers.any(Post.class))).thenReturn(post);

        Post result = postService.createPost(post);
        assertNotNull(result);
        assertEquals("Post one", result.getContent());
    }

    @Test
    void testGetPostsByUser() {
        User user = new User("john_doe", "john@example.com");
        List<Post> posts = List.of(new Post("Post one", LocalDateTime.now(), user));
        when(postRepository.findByUserId(1L)).thenReturn(posts);

        List<Post> result = postService.getPostsByUser(1L);
        assertFalse(result.isEmpty());
        assertEquals("Post one", result.get(0).getContent());
    }
}