package com.miu.edu.waalab1.repository;

import com.miu.edu.waalab1.domain.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();

    Post getById(long id);

    public void save(Post p);

    public void delete(long id);

    public void update(long id, Post p);
}
