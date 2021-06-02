package com.portfolio.website.controller;

import com.portfolio.website.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostsService postsService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "home";
    }
}
