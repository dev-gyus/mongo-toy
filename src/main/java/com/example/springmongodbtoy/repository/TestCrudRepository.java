package com.example.springmongodbtoy.repository;

import com.example.springmongodbtoy.dao.TestDao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestCrudRepository extends MongoRepository<TestDao, String> {
}
