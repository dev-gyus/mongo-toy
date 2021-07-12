package com.example.springmongodbtoy.payload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String id;
    private String name;
    private String email;
    private String movie_id;
    private String text;
    private LocalDateTime date;
}
