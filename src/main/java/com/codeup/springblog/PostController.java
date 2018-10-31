package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class PostController {


//    List<Post> posts = new ArrayList<>();
    private PostService postService;

    public PostController(PostService service){
        this.postService = service;
    }

    //    GET	/ads	ads index page
    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
//        posts.add(new Post());
//        posts.add(new Post());
        vModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    //    GET	/ads/{id}	view an individual post
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model vModel) {
//        vModel.addAttribute("post", posts.get(id-1));
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    //    GET	/ads/create	view the form for creating a post
    @GetMapping("/posts/create")
    public String showPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/show";
    }

    //    POST	/ads/create	create a new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        Post savePost =  postService.save(post);
        return "redirect:/posts" + savePost.getId();
    }

    @GetMapping("/posts/{id}/update")
    public String showUpdateForm(@PathVariable int id, Model vModel){
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/update";
    }

    @PostMapping("/posts/{id}/update")
    public String showUpdateForm(@ModelAttribute Post post){
        Post updatePost = postService.update(post);
        return "redirect:/posts/" + updatePost.getId();
    }
}
