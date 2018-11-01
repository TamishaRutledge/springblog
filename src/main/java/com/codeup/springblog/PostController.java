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

    //    GET	/posts	posts index page
    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
//        posts.add(new Post());
//        posts.add(new Post());
        vModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    //    GET	/post/{id}	view an individual post
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model vModel) {
//        vModel.addAttribute("post", posts.get(id-1));
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    //    GET	/post/create	view the form for creating a post
    @GetMapping("/posts/create")
    public String showPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    //    POST	/post/create	create a new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        Post savePost =  postService.save(post);
        return "redirect:/posts/" + savePost.getId();
    }

    //    GET /post/{id}/update update posts
    @GetMapping("/posts/{id}/update")
    public String showUpdateForm(@PathVariable int id, Model vModel){
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/update";
    }

    //    POST /post/{id}/update update posts
    @PostMapping("/posts/{id}/update")
    public String showUpdateForm(@ModelAttribute Post post){
        Post updatePost = postService.update(post);
        return "redirect:/posts/" + updatePost.getId();
    }

    //    GET /posts/{id}/delete delete posts
    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable int id, Model vModel){
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/delete";
    }

    //   POST /posts/{id}/delete delete posts
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post){
        Post deletePost = postService.remove(post);
        return "redirect:/posts/" + deletePost;
    }

}
