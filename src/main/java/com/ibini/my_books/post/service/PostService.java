package com.ibini.my_books.post.service;

import com.ibini.my_books.post.domain.Post;
import com.ibini.my_books.post.domain.PostWithName;
import com.ibini.my_books.post.repository.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public boolean saveService(Post post){
        log.info("Post Service : saveService call - {}", post);
        return postMapper.save(post);
    }

    public List<Post> findAllPostService(){
        log.info("Post Service : findAllService call");
        return postMapper.findAllPost();
    }

    public List<PostWithName> finaAllPostWithNameService(){
        log.info("Post Service : finaAllPostWithNameService call");
        return postMapper.findAllPostWithName();
    }

    public Post findOnePostService(Long postNo){
        log.info("Post Service : findOnePostService call");
        return postMapper.findOnePost(postNo);
    }

    public boolean removeService(Long postNo){
        log.info("Post Service : removeService call - {}", postNo);
        return postMapper.remove(postNo);
    }

    public boolean modifyService(Post post){
        log.info("Post Service : modifyeService call - {}", post);
        return postMapper.modify(post);
    }

    public int getTotalCount(){
        log.info("Post Service : getTotalCountService call");
        return postMapper.getTotalCount();
    }

}