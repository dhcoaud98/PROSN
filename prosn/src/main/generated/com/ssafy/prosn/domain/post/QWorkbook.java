package com.ssafy.prosn.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkbook is a Querydsl query type for Workbook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWorkbook extends EntityPathBase<Workbook> {

    private static final long serialVersionUID = 2117738059L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWorkbook workbook = new QWorkbook("workbook");

    public final QPost _super;

    //inherited
    public final ListPath<com.ssafy.prosn.domain.comment.Comment, com.ssafy.prosn.domain.comment.QComment> comments;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final ListPath<LikeDislike, QLikeDislike> likeDislikes;

    //inherited
    public final ListPath<PostTag, QPostTag> postTags;

    public final ListPath<ProblemWorkbook, QProblemWorkbook> problemWorkbooks = this.<ProblemWorkbook, QProblemWorkbook>createList("problemWorkbooks", ProblemWorkbook.class, QProblemWorkbook.class, PathInits.DIRECT2);

    //inherited
    public final StringPath title;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated;

    // inherited
    public final com.ssafy.prosn.domain.user.QUser user;

    //inherited
    public final NumberPath<Integer> views;

    public QWorkbook(String variable) {
        this(Workbook.class, forVariable(variable), INITS);
    }

    public QWorkbook(Path<? extends Workbook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWorkbook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWorkbook(PathMetadata metadata, PathInits inits) {
        this(Workbook.class, metadata, inits);
    }

    public QWorkbook(Class<? extends Workbook> type, PathMetadata metadata, PathInits inits) {
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

