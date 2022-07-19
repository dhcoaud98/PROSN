package com.ssafy.prosn.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSocialUser is a Querydsl query type for SocialUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSocialUser extends EntityPathBase<SocialUser> {

    private static final long serialVersionUID = -1286624930L;

    public static final QSocialUser socialUser = new QSocialUser("socialUser");

    public final QUser _super = new QUser(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public final StringPath oauthId = createString("oauthId");

    public final StringPath platform = createString("platform");

    //inherited
    public final NumberPath<Integer> point = _super.point;

    //inherited
    public final ListPath<com.ssafy.prosn.domain.post.Post, com.ssafy.prosn.domain.post.QPost> posts = _super.posts;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public QSocialUser(String variable) {
        super(SocialUser.class, forVariable(variable));
    }

    public QSocialUser(Path<? extends SocialUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocialUser(PathMetadata metadata) {
        super(SocialUser.class, metadata);
    }

}

