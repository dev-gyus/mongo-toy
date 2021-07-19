package com.example.springmongodbtoy.repository;

import com.example.springmongodbtoy.dao.CommentDao;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CommentCrudRepository extends MongoRepository<CommentDao, String>, QuerydslPredicateExecutor<CommentDao> {
    Slice<CommentDao> findAllBy(Pageable pageable);

}
