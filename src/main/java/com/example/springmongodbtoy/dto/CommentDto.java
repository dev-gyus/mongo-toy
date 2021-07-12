package com.example.springmongodbtoy.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private String id;
    private String name;
    private String email;
    private String movie_id;
    private String text;
    private LocalDateTime date;

}
