package com.portfolio.website.controller;

import com.portfolio.website.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @RequestMapping("/posts")
    public String home(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "home1";
    }
}
