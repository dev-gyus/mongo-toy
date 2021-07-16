package com.example.springmongodbtoy.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoDatabaseFactorySupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(){
        return new SimpleMongoClientDatabaseFactory(connectionString);
    }

//    @Bean
//    public MongoTemplate mongoTemplate(){
//        return new MongoTemplate(mongoDatabaseFactory());
//    }

    // @Transactional(readOnly = true) 에서 save하면 insert 됨 ㅋㅋㅋ
//    @Bean
//    public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory){
//        return new MongoTransactionManager(mongoDatabaseFactory);
//    }

    // @Transactional(readOnly = true) 에서 save하면 예외발생
    @Bean
    public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory){
        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(mongoDatabaseFactory);
        mongoTransactionManager.setValidateExistingTransaction(true);
        mongoTransactionManager.setNestedTransactionAllowed(true);
        return mongoTransactionManager;
    }
}
