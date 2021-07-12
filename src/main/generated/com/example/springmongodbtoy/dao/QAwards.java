package com.example.springmongodbtoy.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAwards is a Querydsl query type for Awards
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAwards extends BeanPath<Awards> {

    private static final long serialVersionUID = 1655934678L;

    public static final QAwards awards = new QAwards("awards");

    public final NumberPath<Long> nominations = createNumber("nominations", Long.class);

    public final StringPath text = createString("text");

    public final NumberPath<Long> wins = createNumber("wins", Long.class);

    public QAwards(String variable) {
        super(Awards.class, forVariable(variable));
    }

    public QAwards(Path<? extends Awards> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAwards(PathMetadata metadata) {
        super(Awards.class, metadata);
    }

}

