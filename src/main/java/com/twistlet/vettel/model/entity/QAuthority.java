package com.twistlet.vettel.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAuthority is a Querydsl query type for Authority
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAuthority extends EntityPathBase<Authority> {

    private static final long serialVersionUID = 274332616;

    public static final QAuthority authority1 = new QAuthority("authority1");

    public final StringPath authority = createString("authority");

    public final StringPath description = createString("description");

    public QAuthority(String variable) {
        super(Authority.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAuthority(Path<? extends Authority> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QAuthority(PathMetadata<?> metadata) {
        super(Authority.class, metadata);
    }

}

