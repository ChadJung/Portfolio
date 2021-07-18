package com.portfolio.website.controller;

import com.portfolio.website.domain.Posts;
import com.portfolio.website.form.BookForm;
import com.portfolio.website.form.PostForm;
import com.portfolio.website.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @RequestMapping("/posts")
    public String home(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts/postList";
    }

    @GetMapping("/posts/new")
    public String createForm(Model model) {
        model.addAttribute("form", new PostForm());
        return "posts/createPostForm";
    }

    @GetMapping("/posts/{postId}/edit")
    public String updatePostForm(@PathVariable("postId") Long id, Model model) {
        Optional<Posts> postOp = postsService.findById(id);

        if(postOp.isEmpty())
            return "posts/postList";

        Posts post = postOp.get();
        PostForm form = new PostForm(post.getId(), post.getAuthor(), post.getContent());
        model.addAttribute("form", form);

        return "posts/updatePost Form";
    }

    @PostMapping("/posts/{postId}/edit")
    public String updatePost(@PathVariable("postId") Long id, @ModelAttribute("form") PostForm form) {
        postsService.updatePost(form.getId(), form.getAuthor(), form.getContent());
        return "posts/postList";
    }
}
