package com.example.springmongodbtoy.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentDao is a Querydsl query type for CommentDao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommentDao extends EntityPathBase<CommentDao> {

    private static final long serialVersionUID = -869877293L;

    public static final QCommentDao commentDao = new QCommentDao("commentDao");

    public final QAuditing _super = new QAuditing(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDt = _super.createdDt;

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final ComparablePath<org.bson.types.ObjectId> id = createComparable("id", org.bson.types.ObjectId.class);

    public final ComparablePath<org.bson.types.ObjectId> movie_id = createComparable("movie_id", org.bson.types.ObjectId.class);

    public final StringPath name = createString("name");

    public final StringPath text = createString("text");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public QCommentDao(String variable) {
        super(CommentDao.class, forVariable(variable));
    }

    public QCommentDao(Path<? extends CommentDao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentDao(PathMetadata metadata) {
        super(CommentDao.class, metadata);
    }

}

