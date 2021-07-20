package com.example.springmongodbtoy.dao;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Document(collection = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentDao extends Auditing{
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private ObjectId movie_id;
    private String text;
    private LocalDateTime date;
    private List<String> testList;
}
