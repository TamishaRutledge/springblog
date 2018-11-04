package com.codeup.springblog;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository <Post, Long> {
    @Query("from Post where title like %?1% or body like %?1%")
    List<Post> searchByTitleOrDesc(String term);

}
