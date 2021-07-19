package com.example.springmongodbtoy.controller;

import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.payload.model.Comment;
import com.example.springmongodbtoy.payload.request.CommentRequest;
import com.example.springmongodbtoy.payload.response.TransactionResponse;
import com.example.springmongodbtoy.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
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
        CommentDto dto = transactionService.saveException(modelMapper.map(commentRequest, CommentDto.class));
        Comment model = modelMapper.map(dto, Comment.class);
        return new ResponseEntity<>(modelMapper.map(model, TransactionResponse.class), HttpStatus.OK);
    }

    @PostMapping("/normal")
    public ResponseEntity<TransactionResponse> transactionExample(@RequestBody CommentRequest commentRequest){
//        CommentDto dto = transactionService.save(modelMapper.map(commentRequest, CommentDto.class));
        CommentDto dto = transactionService.isolationSaveTest(modelMapper.map(commentRequest, CommentDto.class));
        Comment model = modelMapper.map(dto, Comment.class);
        return new ResponseEntity<>(TransactionResponse.builder().comment(model).build(), HttpStatus.OK);
    }

    @PostMapping("/update-multi")
    public ResponseEntity<TransactionResponse> updateMultiException(@RequestBody CommentRequest commentRequest){
        CommentDto dto = transactionService.updateManyException(modelMapper.map(commentRequest, CommentDto.class));
        Comment model = modelMapper.map(new CommentDto(), Comment.class);
        return new ResponseEntity<>(TransactionResponse.builder().comment(model).build(), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<TransactionResponse> findOne(@PathVariable String commentId){
        CommentDto dto = transactionService.isolationReadTest(commentId);
        Comment model = modelMapper.map(dto, Comment.class);
        return new ResponseEntity<>(TransactionResponse.builder().comment(model).build(), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<TransactionResponse> findAll(){
        List<CommentDto> dtoList = transactionService.isolationReadAll();
        List<Comment> modelList = dtoList.stream().map(dto -> modelMapper.map(dto, Comment.class)).collect(Collectors.toList());
        return new ResponseEntity<>(TransactionResponse.builder().commentList(modelList).build(), HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<TransactionResponse> updateOne(@PathVariable String commentId){
        CommentDto dto = transactionService.isolationUpdateTest(commentId);
        Comment model = modelMapper.map(dto, Comment.class);
        return new ResponseEntity<>(TransactionResponse.builder().comment(model).build(), HttpStatus.OK);
    }
}
