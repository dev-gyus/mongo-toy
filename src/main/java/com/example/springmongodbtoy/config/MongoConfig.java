package com.example.springmongodbtoy.config;

import com.example.springmongodbtoy.dao.CommentEventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig{
    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(){
        return new SimpleMongoClientDatabaseFactory(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDatabaseFactory());
    }

    // @Transactional(readOnly = true) 에서 save하면 insert 됨 ㅋㅋㅋ
//    @Bean
//    public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory){
//        return new MongoTransactionManager(mongoDatabaseFactory);
//    }

    @Bean
    public CommentEventListener beforeSaveListener(){
        return new CommentEventListener();
    }

    @Bean
    public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory){
        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(mongoDatabaseFactory);
        return mongoTransactionManager;
    }
}
