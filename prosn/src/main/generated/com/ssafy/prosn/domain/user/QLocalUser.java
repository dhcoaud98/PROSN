package com.ssafy.prosn.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocalUser is a Querydsl query type for LocalUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocalUser extends EntityPathBase<LocalUser> {

    private static final long serialVersionUID = 1307359376L;

    public static final QLocalUser localUser = new QLocalUser("localUser");

    public final QUser _super = new QUser(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public final StringPath password = createString("password");

    //inherited
    public final NumberPath<Integer> point = _super.point;

    //inherited
    public final ListPath<com.ssafy.prosn.domain.post.Post, com.ssafy.prosn.domain.post.QPost> posts = _super.posts;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final StringPath userId = createString("userId");

    public QLocalUser(String variable) {
        super(LocalUser.class, forVariable(variable));
    }

    public QLocalUser(Path<? extends LocalUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocalUser(PathMetadata metadata) {
        super(LocalUser.class, metadata);
    }

}

