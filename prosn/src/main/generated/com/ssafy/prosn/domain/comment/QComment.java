package com.ssafy.prosn.domain.comment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -1972104173L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final com.ssafy.prosn.domain.QBaseEntity _super = new com.ssafy.prosn.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mainText = createString("mainText");

    public final com.ssafy.prosn.domain.post.QPost post;

    public final ListPath<Reply, QReply> replies = this.<Reply, QReply>createList("replies", Reply.class, QReply.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final com.ssafy.prosn.domain.user.QUser user;

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.ssafy.prosn.domain.post.QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.ssafy.prosn.domain.user.QUser(forProperty("user")) : null;
    }

}

