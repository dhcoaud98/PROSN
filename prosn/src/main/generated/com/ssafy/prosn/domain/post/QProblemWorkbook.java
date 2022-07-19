package com.ssafy.prosn.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProblemWorkbook is a Querydsl query type for ProblemWorkbook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProblemWorkbook extends EntityPathBase<ProblemWorkbook> {

    private static final long serialVersionUID = -1762640056L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProblemWorkbook problemWorkbook = new QProblemWorkbook("problemWorkbook");

    public final com.ssafy.prosn.domain.QBaseEntity _super = new com.ssafy.prosn.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProblem problem;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final QWorkbook workbook;

    public QProblemWorkbook(String variable) {
        this(ProblemWorkbook.class, forVariable(variable), INITS);
    }

    public QProblemWorkbook(Path<? extends ProblemWorkbook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProblemWorkbook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProblemWorkbook(PathMetadata metadata, PathInits inits) {
        this(ProblemWorkbook.class, metadata, inits);
    }

    public QProblemWorkbook(Class<? extends ProblemWorkbook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.problem = inits.isInitialized("problem") ? new QProblem(forProperty("problem"), inits.get("problem")) : null;
        this.workbook = inits.isInitialized("workbook") ? new QWorkbook(forProperty("workbook"), inits.get("workbook")) : null;
    }

}

