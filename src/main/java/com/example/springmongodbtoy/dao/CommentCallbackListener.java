package com.example.springmongodbtoy.dao;

import com.example.springmongodbtoy.dto.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class CommentCallbackListener implements AfterConvertCallback<CommentDto>{
    @Override
    public CommentDto onAfterConvert(CommentDto entity, Document document, String collection) {
        log.info("callback Listener 진입 document to json = {}", document.toJson());
        return entity;
    }
}
