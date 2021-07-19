package com.example.springmongodbtoy.service;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.repository.CommentCrudRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PageableService {
    private final CommentCrudRepository commentCrudRepository;
    private final ModelMapper modelMapper;


    public List<CommentDto> findCommentList(Pageable pageable) {
        Slice<CommentDao> daoSlice = commentCrudRepository.findAllBy(pageable);
        Slice<CommentDto> dtoSlice = daoSlice.map(dao -> modelMapper.map(dao, CommentDto.class));
        return dtoSlice.getContent();
    }
}
