package automechanicsmall;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReceipt is a Querydsl query type for Receipt
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReceipt extends EntityPathBase<Receipt> {

    private static final long serialVersionUID = -895789858L;

    public static final QReceipt receipt = new QReceipt("receipt");

    public final NumberPath<Integer> acptAmt = createNumber("acptAmt", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath rcptDate = createString("rcptDate");

    public final NumberPath<Integer> rcptSeq = createNumber("rcptSeq", Integer.class);

    public final NumberPath<Integer> reprAmt = createNumber("reprAmt", Integer.class);

    public final StringPath resvDate = createString("resvDate");

    public final StringPath resvTime = createString("resvTime");

    public final StringPath stat = createString("stat");

    public final StringPath vehiNo = createString("vehiNo");

    public QReceipt(String variable) {
        super(Receipt.class, forVariable(variable));
    }

    public QReceipt(Path<? extends Receipt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReceipt(PathMetadata metadata) {
        super(Receipt.class, metadata);
    }

}

