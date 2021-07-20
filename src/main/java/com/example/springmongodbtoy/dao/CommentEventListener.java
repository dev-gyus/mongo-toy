package com.example.springmongodbtoy.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
public class CommentEventListener extends AbstractMongoEventListener<CommentDao>{
    @Override
    public void onBeforeConvert(BeforeConvertEvent<CommentDao> event) {
        log.info("onBeforeConvertEvent 진입");
    }

    @Override
    public void onBeforeSave(BeforeSaveEvent<CommentDao> event) {
        log.info("onBeforeSave 진입, date now값 세팅");
        CommentDao source = event.getSource();
        source.setDate(LocalDateTime.now());
        log.info("on Before Save called json = {}", event.getDocument().toJson());
    }

    @Override
    public void onAfterSave(AfterSaveEvent<CommentDao> event) {
        log.info("onAfterSaveEvent 진입");

    }

    @Override
    public void onAfterLoad(AfterLoadEvent<CommentDao> event) {
        log.info("onAfterLoadEvent 진입");
        log.info("document to Json = {}",event.getDocument().toJson());
    }

    @Override
    public void onAfterConvert(AfterConvertEvent<CommentDao> event) {
        log.info("onAfterConvertEvent 진입");
        log.info("document to Json = {}",event.getDocument().toJson());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<CommentDao> event) {
        log.info("onAfterDeleteEvent 진입");

    }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<CommentDao> event) {
        log.info("onBeforeConvertEvent 진입");

    }
}
