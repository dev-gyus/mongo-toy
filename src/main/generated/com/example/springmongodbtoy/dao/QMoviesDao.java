package com.example.springmongodbtoy.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMoviesDao is a Querydsl query type for MoviesDao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMoviesDao extends EntityPathBase<MoviesDao> {

    private static final long serialVersionUID = -115529681L;

    public static final QMoviesDao moviesDao = new QMoviesDao("moviesDao");

    public final SimplePath<Awards> awards = createSimple("awards", Awards.class);

    public final ListPath<String, StringPath> cast = this.<String, StringPath>createList("cast", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<String, StringPath> countries = this.<String, StringPath>createList("countries", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<String, StringPath> directors = this.<String, StringPath>createList("directors", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath fullplot = createString("fullplot");

    public final ListPath<String, StringPath> genres = this.<String, StringPath>createList("genres", String.class, StringPath.class, PathInits.DIRECT2);

    public final ComparablePath<org.bson.types.ObjectId> id = createComparable("id", org.bson.types.ObjectId.class);

    public final StringPath lastupdated = createString("lastupdated");

    public final NumberPath<Long> num_mflix_comments = createNumber("num_mflix_comments", Long.class);

    public final StringPath plot = createString("plot");

    public final StringPath rated = createString("rated");

    public final DateTimePath<java.time.LocalDateTime> released = createDateTime("released", java.time.LocalDateTime.class);

    public final NumberPath<Long> runtime = createNumber("runtime", Long.class);

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final NumberPath<Long> year = createNumber("year", Long.class);

    public QMoviesDao(String variable) {
        super(MoviesDao.class, forVariable(variable));
    }

    public QMoviesDao(Path<? extends MoviesDao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoviesDao(PathMetadata metadata) {
        super(MoviesDao.class, metadata);
    }

}

