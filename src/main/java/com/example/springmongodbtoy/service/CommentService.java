package com.example.springmongodbtoy.service;

import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.repository.query.CommentRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepositorySupport impleRepository;

    public List<CommentDto> getAllComments(String name) {
        return impleRepository.findAllByName(name);
    }

    public List<CommentDto> getAllMoviesCommentsByQueryDsl(String title){
        return impleRepository.findAllCommentsByQueryDsl(title);
    }

    public List<CommentDto> getAllMoviesCommentsByMongoTemplate(String title){
        return impleRepository.findAllCommentsByMongoTemplate(title);
    }
}
