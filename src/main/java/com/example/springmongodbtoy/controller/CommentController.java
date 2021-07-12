package com.example.springmongodbtoy.controller;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.payload.model.Comment;
import com.example.springmongodbtoy.payload.response.CommentResponse;
import com.example.springmongodbtoy.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mongodb")
public class CommentController {
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @GetMapping("/comments")
    public ResponseEntity<CommentResponse> getComments(String name){
        List<CommentDto> dtoList = commentService.getAllComments(name);
        List<Comment> model = dtoList.stream().map(dto -> modelMapper.map(dto, Comment.class)).collect(Collectors.toList());
        CommentResponse response = CommentResponse.builder().commentDaoList(model).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/movies/comments/querydsl")
    public ResponseEntity<CommentResponse> getMoviesCommentsByQueryDsl(String title){
        List<CommentDto> dtoList = commentService.getAllMoviesCommentsByQueryDsl(title);
        List<Comment> modelList = dtoList.stream().map(dto -> modelMapper.map(dto, Comment.class)).collect(Collectors.toList());
        CommentResponse res = CommentResponse.builder().commentDaoList(modelList).build();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/movies/comments/mongo-template")
    public ResponseEntity<CommentResponse> getMoviesCommentsByMongoTemplate(String title){
        List<CommentDto> dtoList = commentService.getAllMoviesCommentsByMongoTemplate(title);
        List<Comment> modelList = dtoList.stream().map(dto -> modelMapper.map(dto, Comment.class)).collect(Collectors.toList());
        CommentResponse res = CommentResponse.builder().commentDaoList(modelList).build();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
