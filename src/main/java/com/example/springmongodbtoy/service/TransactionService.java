package com.example.springmongodbtoy.service;

import com.example.springmongodbtoy.dao.CommentDao;
import com.example.springmongodbtoy.dao.TestDao;
import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.repository.CommentCrudRepository;
import com.example.springmongodbtoy.repository.write.TransactionWriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    private final MongoTemplate mongoTemplate;
    private final TransactionWriteRepository transactionWriteRepository;
    private final CommentCrudRepository commentCrudRepository;
    private final ModelMapper modelMapper;

    // 다른 컬렉션, 다중 문서에 대해서 Transaction 작동됨
    @Transactional
    public CommentDto saveException(CommentDto dto){
        CommentDto returnDto = transactionWriteRepository.saveException(dto);
        CommentDto returnDto2 = transactionWriteRepository.saveException(dto);
        TestDao testDao = new TestDao();
        testDao.setName("테스트");
        transactionWriteRepository.saveTestException(testDao);
        throw new RuntimeException("예외발생!!");
    }

    // readOnly 제대로 작동 안됨...
    @Transactional(readOnly = true)
    public CommentDto save(CommentDto dto) {
        CommentDto save = transactionWriteRepository.save(dto);
        log.info("is transaction working? {}", TransactionSynchronizationManager.isActualTransactionActive());
        log.info("is transaction working readOnly? {}", TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        return save;
    }

    // update many에 대해서도 트랜잭션 동작함
    @Transactional
    public CommentDto updateManyException(CommentDto dto){
        TestDao testDao = new TestDao();
        testDao.setName("테스트");
        transactionWriteRepository.updateMany(dto);
        throw new RuntimeException("예외발생!!!");
    }

    //    // 정상동작
//    @Transactional
//    public CommentDto updateMany(CommentDto commentDto){
//        TestDao testDao = new TestDao();
//        testDao.setName("테스트");
//        transactionWriteRepository.updateMany(commentDto);
//        return null;
//    }

    @Transactional
    public CommentDto isolationSaveTest(CommentDto dto) {
        log.info("before send query");
        CommentDto save = transactionWriteRepository.save(dto);
        log.info("after send query");
        return save;
    }

    public List<CommentDto> isolationReadAll(){
        return commentCrudRepository.findAll().stream().map(dao -> modelMapper.map(dao, CommentDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public CommentDto isolationUpdateTest(String id) {
        log.info("before send query");
        CommentDto dto = transactionWriteRepository.updateOne(id);
        log.info("after send query");
        return dto;
    }

    public CommentDto isolationReadTest(String id){
        CommentDao dao = commentCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("해당 id의 댓글을 찾을 수 없습니다")
        );
        return modelMapper.map(dao, CommentDto.class);
    }




}
