package com.miu.edu.waalab1.repository;

import com.miu.edu.waalab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{

    private static List<Post> posts;
    private static long postId = 400;
    static {

        posts = new ArrayList<>();

        Post p1 = new Post(1, "Head First Design Patterns",
                "Variety of Patterns", "Kathy Sierra");
        Post p2 = new Post(2, "Head first WAA & Frameworks",
                "Spring Data", "Rich Rosen");

        posts.add(p1);
        posts.add(p2);
    }

    public List<Post> findAll(){

        return posts;
    }

    public Post getById(long id){
        return posts
                .stream()
                .filter((l -> l.getId() == id))
                .findFirst()
                .orElse(null);
    }

    public void save(Post p){
        p.setId(postId);
        postId++;
        posts.add(p);
    }

    @Override
    public void delete(long id){
        var post = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .get();
        posts.remove(post);
    }

    @Override
    public void update(long id, Post p){
        Post toUpdate = getById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }

}
