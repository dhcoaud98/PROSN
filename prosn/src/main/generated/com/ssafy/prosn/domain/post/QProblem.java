package com.ssafy.prosn.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProblem is a Querydsl query type for Problem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProblem extends EntityPathBase<Problem> {

    private static final long serialVersionUID = -1212196946L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProblem problem = new QProblem("problem");

    public final QPost _super;

    public final StringPath answer = createString("answer");

    //inherited
    public final ListPath<com.ssafy.prosn.domain.comment.Comment, com.ssafy.prosn.domain.comment.QComment> comments;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created;

    public final StringPath example1 = createString("example1");

    public final StringPath example2 = createString("example2");

    public final StringPath example3 = createString("example3");

    public final StringPath example4 = createString("example4");

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

    public QProblem(String variable) {
        this(Problem.class, forVariable(variable), INITS);
    }

    public QProblem(Path<? extends Problem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProblem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProblem(PathMetadata metadata, PathInits inits) {
        this(Problem.class, metadata, inits);
    }

    public QProblem(Class<? extends Problem> type, PathMetadata metadata, PathInits inits) {
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

