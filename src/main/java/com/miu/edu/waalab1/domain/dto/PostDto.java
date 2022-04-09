package com.miu.edu.waalab1.domain.dto;

import lombok.Data;

@Data
public class PostDto {

    private long id;
    private String title;
    private String content;
    private String author;

}
