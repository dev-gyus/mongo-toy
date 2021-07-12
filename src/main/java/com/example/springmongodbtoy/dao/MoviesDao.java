package com.example.springmongodbtoy.dao;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@QueryEntity
@Document("movies")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDao {
    private ObjectId id;
    private String plot;
    private List<String> genres;
    private long runtime;
    private List<String> cast;
    private long num_mflix_comments;
    private String title;
    private String fullplot;
    private List<String> countries;
    private LocalDateTime released;
    private List<String> directors;
    private String rated;
    @DBRef
    private Awards awards;
    private String lastupdated;
    private long year;
    private String type;
}
