package com.portfolio.website.service;

import com.portfolio.website.domain.Posts;
import com.portfolio.website.dto.PostsMainResponseDto;
import com.portfolio.website.dto.PostsSaveRequestDto;
import com.portfolio.website.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }

    public void updatePost(Long id, String author, String content) {
        Posts post = postsRepository.findById(id).get();
        post.setAuthor(author);
        post.setContent(content);
    }
}
