package com.example.springmongodbtoy.repository;

import com.example.springmongodbtoy.dao.CommentDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CommentCrudRepository extends MongoRepository<CommentDao, String>, QuerydslPredicateExecutor<CommentDao> {
}
