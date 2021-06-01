package com.portfolio.website.service;

import com.portfolio.website.domain.Posts;
import com.portfolio.website.dto.PostsSaveRequestDto;
import com.portfolio.website.repository.PostsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void saveTest() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("jungsj11@gmail.com")
                .content("test content")
                .title("test title")
                .build();
        //when
        long save = postsService.save(dto);

        //then
        Posts post = postsRepository.findById(save).get();
        assertEquals(post.getAuthor(), dto.getAuthor());
        assertEquals(post.getTitle(), dto.getTitle());
        assertEquals(post.getContent(), dto.getContent());
    }
}