package com.example.springmongodbtoy.repository.query;

import com.example.springmongodbtoy.dto.CommentDto;

import java.util.List;

public interface CommentQueryRepository {
    List<CommentDto> findAllByName(String name);
}
