package com.example.springmongodbtoy.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTestDao is a Querydsl query type for TestDao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTestDao extends EntityPathBase<TestDao> {

    private static final long serialVersionUID = -1021604736L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTestDao testDao = new QTestDao("testDao");

    public final org.bson.types.QObjectId id;

    public final StringPath name = createString("name");

    public QTestDao(String variable) {
        this(TestDao.class, forVariable(variable), INITS);
    }

    public QTestDao(Path<? extends TestDao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTestDao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTestDao(PathMetadata metadata, PathInits inits) {
        this(TestDao.class, metadata, inits);
    }

    public QTestDao(Class<? extends TestDao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

