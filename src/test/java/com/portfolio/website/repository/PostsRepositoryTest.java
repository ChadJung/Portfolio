package com.portfolio.website.repository;

import com.portfolio.website.domain.Posts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void abc() {
        //given
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("sjsj")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo("테스트 게시글");
        assertThat(posts.getContent()).isEqualTo("테스트 본문");
        assertThat(posts.getAuthor()).isEqualTo("sjsj");
    }



}