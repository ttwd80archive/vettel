package com.twistlet.vettel.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPersonAuthority is a Querydsl query type for PersonAuthority
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPersonAuthority extends EntityPathBase<PersonAuthority> {

    private static final long serialVersionUID = 1920940083;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPersonAuthority personAuthority = new QPersonAuthority("personAuthority");

    public final QAuthority authority;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QPerson person;

    public QPersonAuthority(String variable) {
        this(PersonAuthority.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QPersonAuthority(Path<? extends PersonAuthority> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPersonAuthority(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPersonAuthority(PathMetadata<?> metadata, PathInits inits) {
        this(PersonAuthority.class, metadata, inits);
    }

    public QPersonAuthority(Class<? extends PersonAuthority> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.authority = inits.isInitialized("authority") ? new QAuthority(forProperty("authority")) : null;
        this.person = inits.isInitialized("person") ? new QPerson(forProperty("person")) : null;
    }

}

