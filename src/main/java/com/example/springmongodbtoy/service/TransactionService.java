package com.example.springmongodbtoy.service;

import com.example.springmongodbtoy.dao.TestDao;
import com.example.springmongodbtoy.dto.CommentDto;
import com.example.springmongodbtoy.repository.CommentCrudRepository;
import com.example.springmongodbtoy.repository.write.TransactionWriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionWriteRepository transactionWriteRepository;
    private final CommentCrudRepository commentCrudRepository;
    private final ModelMapper modelMapper;

    // 다른 컬렉션, 다중 문서에 대해서 Transaction 작동됨
    @Transactional
    public CommentDto saveException(CommentDto commentDto){
        CommentDto returnDto = transactionWriteRepository.saveException(commentDto);
        CommentDto returnDto2 = transactionWriteRepository.saveException(commentDto);
        TestDao testDao = new TestDao();
        testDao.setName("테스트");
        transactionWriteRepository.saveTestException(testDao);
        throw new RuntimeException("예외발생!!");
    }

    // readOnly 제대로 작동 안됨...
    @Transactional(readOnly = true)
    public CommentDto save(CommentDto map) {
        CommentDto save = transactionWriteRepository.save(map);
        log.info("is transaction working? {}", TransactionSynchronizationManager.isActualTransactionActive());
        log.info("is transaction working readOnly? {}", TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        return save;
    }

    // update many에 대해서도 트랜잭션 동작함
    @Transactional
    public CommentDto saveManyException(CommentDto commentDto){
        TestDao testDao = new TestDao();
        testDao.setName("테스트");
        transactionWriteRepository.updateMany(commentDto);
        throw new RuntimeException("예외발생!!!");
    }

//    // 정상동작
//    @Transactional
//    public CommentDto saveManyException(CommentDto commentDto){
//        TestDao testDao = new TestDao();
//        testDao.setName("테스트");
//        transactionWriteRepository.updateMany(commentDto);
//        return null;
//    }


}
