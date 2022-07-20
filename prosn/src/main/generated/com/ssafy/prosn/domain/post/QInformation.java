package com.ssafy.prosn.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInformation is a Querydsl query type for Information
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInformation extends EntityPathBase<Information> {

    private static final long serialVersionUID = 185199291L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInformation information = new QInformation("information");

    public final QPost _super;

    //inherited
    public final ListPath<com.ssafy.prosn.domain.comment.Comment, com.ssafy.prosn.domain.comment.QComment> comments;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final ListPath<LikeDislike, QLikeDislike> likeDislikes;

    public final StringPath mainText = createString("mainText");

    //inherited
    public final ListPath<PostTag, QPostTag> postTags;

    //inherited
    public final StringPath title;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated;

    // inherited
    public final com.ssafy.prosn.domain.user.QUser user;

    //inherited
    public final NumberPath<Integer> views;

    public QInformation(String variable) {
        this(Information.class, forVariable(variable), INITS);
    }

    public QInformation(Path<? extends Information> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInformation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInformation(PathMetadata metadata, PathInits inits) {
        this(Information.class, metadata, inits);
    }

    public QInformation(Class<? extends Information> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QPost(type, metadata, inits);
        this.comments = _super.comments;
        this.created = _super.created;
        this.id = _super.id;
        this.likeDislikes = _super.likeDislikes;
        this.postTags = _super.postTags;
        this.title = _super.title;
        this.updated = _super.updated;
        this.user = _super.user;
        this.views = _super.views;
    }

}

