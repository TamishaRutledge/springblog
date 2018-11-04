package com.codeup.springblog;

import org.springframework.stereotype.Service;
import com.codeup.springblog.Post;
import com.codeup.springblog.PostRepository;
import java.util.List;

@Service
public class PostService {


    private PostRepository postRepository;

    public PostService(PostRepository postRepo){
        this.postRepository = postRepo;
    }

    public Iterable<Post> findAll(){
        return postRepository.findAll();
    }

    public Post saveOrUpdate(Post post){
        return postRepository.save(post);
    }


    public Post findOne(int id){
        return postRepository.findOne((long) id);
    }


    public void delete(int id){
        postRepository.delete((long) id);
    }


    public List<Post> search(String term) {
        return postRepository.searchByTitleOrDesc(term);
    }

}
