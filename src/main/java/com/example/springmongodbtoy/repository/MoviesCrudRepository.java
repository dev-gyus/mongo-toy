package com.example.springmongodbtoy.repository;

import com.example.springmongodbtoy.dao.MoviesDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MoviesCrudRepository extends MongoRepository<MoviesDao, String>, QuerydslPredicateExecutor<MoviesDao> {
}
