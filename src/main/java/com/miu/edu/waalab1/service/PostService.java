package com.miu.edu.waalab1.service;

import com.miu.edu.waalab1.domain.Post;
import com.miu.edu.waalab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto getById(long id);

    void save(Post p);

}
