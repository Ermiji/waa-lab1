package com.miu.edu.waalab1.service;

import com.miu.edu.waalab1.domain.Post;
import com.miu.edu.waalab1.domain.dto.PostDto;
import com.miu.edu.waalab1.helper.ListMapper;
import com.miu.edu.waalab1.repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {

        return modelMapper.map( postRepo.getById(id), PostDto.class);
    }

    @Override
    public void save(Post p) {

        postRepo.save(p);
    }
}
