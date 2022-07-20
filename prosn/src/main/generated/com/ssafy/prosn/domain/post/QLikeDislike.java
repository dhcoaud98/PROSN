package com.ssafy.prosn.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLikeDislike is a Querydsl query type for LikeDislike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLikeDislike extends EntityPathBase<LikeDislike> {

    private static final long serialVersionUID = 1402680093L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLikeDislike likeDislike = new QLikeDislike("likeDislike");

    public final com.ssafy.prosn.domain.QBaseEntity _super = new com.ssafy.prosn.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPost post;

    public final BooleanPath type = createBoolean("type");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final com.ssafy.prosn.domain.user.QUser user;

    public QLikeDislike(String variable) {
        this(LikeDislike.class, forVariable(variable), INITS);
    }

    public QLikeDislike(Path<? extends LikeDislike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLikeDislike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLikeDislike(PathMetadata metadata, PathInits inits) {
        this(LikeDislike.class, metadata, inits);
    }

    public QLikeDislike(Class<? extends LikeDislike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.ssafy.prosn.domain.user.QUser(forProperty("user")) : null;
    }

}

