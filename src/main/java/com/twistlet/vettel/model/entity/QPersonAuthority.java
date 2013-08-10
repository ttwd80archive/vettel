package com.twistlet.vettel.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPersonAuthority is a Querydsl query type for PersonAuthority
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPersonAuthority extends EntityPathBase<PersonAuthority> {

    private static final long serialVersionUID = 1920940083;

    public static final QPersonAuthority personAuthority = new QPersonAuthority("personAuthority");

    public final StringPath authority = createString("authority");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath username = createString("username");

    public QPersonAuthority(String variable) {
        super(PersonAuthority.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QPersonAuthority(Path<? extends PersonAuthority> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QPersonAuthority(PathMetadata<?> metadata) {
        super(PersonAuthority.class, metadata);
    }

}

