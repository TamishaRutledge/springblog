package com.codeup.springblog;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService(){
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post update(Post post){
        return posts.set(post.getId() -1, post);

    }

    public Post findOne(int id){
        return posts.get(id - 1);
    }

    private void createPosts(){
        this.save(new Post( 1,"The First Post", "What does the fox say?"));
        this.save(new Post( 2,"I gotta say", "Today was a good day."));
        this.save(new Post( 3,"Another One", "The keys to life according to DJ Khaled."));
    }
}
