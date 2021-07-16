package com.example.springmongodbtoy.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditing is a Querydsl query type for Auditing
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAuditing extends BeanPath<Auditing> {

    private static final long serialVersionUID = 518364999L;

    public static final QAuditing auditing = new QAuditing("auditing");

    public final DateTimePath<java.time.LocalDateTime> createdDt = createDateTime("createdDt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateDt = createDateTime("updateDt", java.time.LocalDateTime.class);

    public QAuditing(String variable) {
        super(Auditing.class, forVariable(variable));
    }

    public QAuditing(Path<? extends Auditing> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditing(PathMetadata metadata) {
        super(Auditing.class, metadata);
    }

}

