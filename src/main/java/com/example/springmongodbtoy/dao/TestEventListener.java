package com.example.springmongodbtoy.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TestEventListener extends AbstractMongoEventListener<TestDao>{
    @Override
    public void onBeforeConvert(BeforeConvertEvent<TestDao> event) {
        log.info("onBeforeConvertEvent 진입");
    }

    @Override
    public void onBeforeSave(BeforeSaveEvent<TestDao> event) {
        log.info("onBeforeSave 진입, date now값 세팅");
        log.info("on Before Save called json = {}", event.getDocument().toJson());
    }

    @Override
    public void onAfterSave(AfterSaveEvent<TestDao> event) {
        log.info("onAfterSaveEvent 진입");

    }

    @Override
    public void onAfterLoad(AfterLoadEvent<TestDao> event) {
        log.info("onAfterLoadEvent 진입");

    }

    @Override
    public void onAfterConvert(AfterConvertEvent<TestDao> event) {
        log.info("onAfterConvertEvent 진입");

    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<TestDao> event) {
        log.info("onAfterDeleteEvent 진입");

    }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<TestDao> event) {
        log.info("onBeforeConvertEvent 진입");

    }
}
