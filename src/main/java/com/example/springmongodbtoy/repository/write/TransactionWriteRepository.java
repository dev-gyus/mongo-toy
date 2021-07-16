package com.example.springmongodbtoy.repository.write;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.dao.TestDao;
import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.dto.TestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Arrays;
import java.util.List;


@Slf4j
@Repository
public class TransactionWriteRepository {
    private final MongoOperations mongoOperations;
    private final ModelMapper modelMapper;
    private final MongoDatabaseFactory mongoDatabaseFactory;

    public TransactionWriteRepository(MongoDatabaseFactory mongoDatabaseFactory, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.mongoOperations = new MongoTemplate(mongoDatabaseFactory);
        this.mongoDatabaseFactory = mongoDatabaseFactory;
    }

    public CommentDto saveException(CommentDto commentDto) {
        CommentDao dao = modelMapper.map(commentDto, CommentDao.class);
        CommentDao savedDao = mongoOperations.save(dao);
        return modelMapper.map(savedDao, CommentDto.class);
    }

    public CommentDto save(CommentDto map) {
        CommentDao dao = mongoOperations.save(modelMapper.map(map, CommentDao.class));
        log.info("repository, is transaction working? {}", TransactionSynchronizationManager.isActualTransactionActive());
        log.info("repository, is transaction working readOnly? {}", TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        return modelMapper.map(dao, CommentDto.class);
    }

    public void saveTestException(TestDao testDao) {
        mongoOperations.save(testDao);
    }

    public void updateMany(CommentDto commentDto) {
        Criteria commentCriteria = new Criteria("name").in(commentDto.getName(), "테스트코멘트");
        Query query = new Query(commentCriteria);
        Update update = new Update();
        update.set("text", "수정된 코멘트 입니다");
        update.set("name", "수정된 이름 입니다");

        mongoOperations.updateMulti(query, update, CommentDao.class).getModifiedCount();
    }
}
