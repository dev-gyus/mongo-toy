package com.example.springmongodbtoy.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private String id;
    private String name;
    private String email;
    private LocalDateTime date;
}
