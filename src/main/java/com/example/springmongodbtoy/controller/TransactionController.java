package com.example.springmongodbtoy.controller;

import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.payload.model.Comment;
import com.example.springmongodbtoy.payload.request.CommentRequest;
import com.example.springmongodbtoy.payload.response.CommentResponse;
import com.example.springmongodbtoy.payload.response.TransactionResponse;
import com.example.springmongodbtoy.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final ModelMapper modelMapper;

    @PostMapping("/exception")
    public ResponseEntity<TransactionResponse> exceptionTransactionExample(@RequestBody CommentRequest commentRequest){
        CommentDto comment = transactionService.saveException(modelMapper.map(commentRequest, CommentDto.class));
        Comment model = modelMapper.map(comment, Comment.class);
        return new ResponseEntity<>(modelMapper.map(model, TransactionResponse.class), HttpStatus.OK);
    }

    @PostMapping("/normal")
    public ResponseEntity<TransactionResponse> transactionExample(@RequestBody CommentRequest commentRequest){
        CommentDto comment = transactionService.save(modelMapper.map(commentRequest, CommentDto.class));
        Comment model = modelMapper.map(comment, Comment.class);
        return new ResponseEntity<>(TransactionResponse.builder().comment(model).build(), HttpStatus.OK);
    }

    @PostMapping("/update-multi")
    public ResponseEntity<TransactionResponse> updateMultiException(@RequestBody CommentRequest commentRequest){
        CommentDto comment = transactionService.saveManyException(modelMapper.map(commentRequest, CommentDto.class));
        Comment model = modelMapper.map(new CommentDto(), Comment.class);
        return new ResponseEntity<>(TransactionResponse.builder().comment(model).build(), HttpStatus.OK);
    }
}
