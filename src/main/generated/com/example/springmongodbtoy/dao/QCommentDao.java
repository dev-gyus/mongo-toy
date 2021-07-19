package com.example.springmongodbtoy.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentDao is a Querydsl query type for CommentDao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommentDao extends EntityPathBase<CommentDao> {

    private static final long serialVersionUID = -869877293L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentDao commentDao = new QCommentDao("commentDao");

    public final QAuditing _super = new QAuditing(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDt = _super.createdDt;

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final org.bson.types.QObjectId id;

    public final org.bson.types.QObjectId movie_id;

    public final StringPath name = createString("name");

    public final StringPath text = createString("text");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public QCommentDao(String variable) {
        this(CommentDao.class, forVariable(variable), INITS);
    }

    public QCommentDao(Path<? extends CommentDao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentDao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentDao(PathMetadata metadata, PathInits inits) {
        this(CommentDao.class, metadata, inits);
    }

    public QCommentDao(Class<? extends CommentDao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
        this.movie_id = inits.isInitialized("movie_id") ? new org.bson.types.QObjectId(forProperty("movie_id")) : null;
    }

}

