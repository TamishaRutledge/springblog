package com.codeup.springblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    private PostService postService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private UserRepository userRepository;

    // Dependency injection is happening
    public PostController(PostService postService){
        this.postService = postService;
    }

    //    GET	/posts	posts index page
    @GetMapping("/posts")
    public String postIndex(Model vModel) {
        vModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    //    GET	/posts/{id}	view an individual post
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    //    GET	/posts/create	view the form for creating a post
    @GetMapping("/posts/create")
    public String showPostForm(Model vModel) {
        vModel.addAttribute("categories", categoriesRepository.findAll());
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    //    POST	/posts/create	create a new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, @RequestParam(value = "categories" , required = false) List<Category> cats) {
        post.setUser(userRepository.findOne(1L));
        post.setCategories(cats);
        Post savedPost = postService.saveOrUpdate(post);
        return "redirect:/posts/" + savedPost.getId();
    }

    //    GET	/posts/update	view the form for updating a post
    @GetMapping("/posts/{id}/update")
    public String showPostUpdateForm(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/update";
    }

    @PostMapping("/posts/{id}/update")
    public String showPostUpdateForm(@ModelAttribute Post post) {
        Post updatedPost = postService.saveOrUpdate(post);
        return "redirect:/posts/" + updatedPost.getId();
    }

    @GetMapping("/posts/search/{term}")
    public String showResults(@PathVariable String term, Model vModel){
        vModel.addAttribute("posts", postService.search(term));
        return "posts/index";
    }

    @PostMapping("/posts/{id}/delete")
    public void rmPost(@PathVariable int id){
        postService.delete(id);
    }

}
