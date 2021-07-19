package com.example.springmongodbtoy.controller;

import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.payload.model.Comment;
import com.example.springmongodbtoy.payload.response.PageableResponse;
import com.example.springmongodbtoy.service.PageableService;
import com.example.springmongodbtoy.util.PageRequest;
import com.example.springmongodbtoy.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pageable")
@RequiredArgsConstructor
public class PageableController {
    private final PageableService pageableService;
    private final ModelMapper modelMapper;

    @GetMapping("/comments")
    public ResponseEntity<PageableResponse> findCommentList(PageRequest pageRequest){
        List<CommentDto> commentDtoList = pageableService.findCommentList(PageUtils.convertPage(pageRequest.getOffset(), pageRequest.getLimit()));
        List<Comment> modelList = commentDtoList.stream().map(dto -> modelMapper.map(dto, Comment.class)).collect(Collectors.toList());
        return new ResponseEntity<>(PageableResponse.builder().commentList(modelList).build(), HttpStatus.OK);
    }
}
