package com.example.springmongodbtoy.repository.write;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.dao.TestDao;
import com.example.springmongodbtoy.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Slf4j
@Repository
@RequiredArgsConstructor
public class TransactionWriteRepository {
    private final ModelMapper modelMapper;
    private final MongoTemplate mongoTemplate;


    public CommentDto saveException(CommentDto commentDto) {
        CommentDao dao = modelMapper.map(commentDto, CommentDao.class);
        CommentDao savedDao = mongoTemplate.save(dao);
        return modelMapper.map(savedDao, CommentDto.class);
    }

    public CommentDto save(CommentDto map) {
        CommentDao dao = mongoTemplate.save(modelMapper.map(map, CommentDao.class));
        log.info("repository, is transaction working? {}", TransactionSynchronizationManager.isActualTransactionActive());
        log.info("repository, is transaction working readOnly? {}", TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        return modelMapper.map(dao, CommentDto.class);
    }

    public void saveTestException(TestDao testDao) {
        mongoTemplate.save(testDao);
    }

    public void updateMany(CommentDto commentDto) {
        Criteria commentCriteria = new Criteria("name").in(commentDto.getName(), "테스트코멘트");
        Query query = new Query(commentCriteria);
        Update update = new Update();
        update.set("text", "수정된 코멘트 입니다");
        update.set("name", "수정된 이름 입니다");

        mongoTemplate.updateMulti(query, update, CommentDao.class).getModifiedCount();
    }

    public CommentDto updateOne(String id) {
        Criteria idCriteria = new Criteria("id").is(id);
        Query query = new Query(idCriteria);
        Update update = new Update();
        update.set("text", "수우우우정된텍스트입니다");
        update.set("name", "수우우우정된네임입니다");

        CommentDao dao = mongoTemplate.findAndModify(query, update, CommentDao.class);
        return modelMapper.map(dao, CommentDto.class);
    }
}
