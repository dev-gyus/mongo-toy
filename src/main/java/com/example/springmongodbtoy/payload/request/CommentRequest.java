package com.example.springmongodbtoy.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private String name;
    private String email;
    private String movie_id;
    private String text;
    private LocalDateTime date;
}
