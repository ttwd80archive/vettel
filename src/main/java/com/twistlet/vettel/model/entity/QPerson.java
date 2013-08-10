package com.twistlet.vettel.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -2113110800;

    public static final QPerson person = new QPerson("person");

    public final NumberPath<Byte> enabled = createNumber("enabled", Byte.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final SetPath<PersonAuthority, QPersonAuthority> personAuthorities = this.<PersonAuthority, QPersonAuthority>createSet("personAuthorities", PersonAuthority.class, QPersonAuthority.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QPerson(Path<? extends Person> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata<?> metadata) {
        super(Person.class, metadata);
    }

}

