package automechanicsmall;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRepair is a Querydsl query type for Repair
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRepair extends EntityPathBase<Repair> {

    private static final long serialVersionUID = 802770983L;

    public static final QRepair repair = new QRepair("repair");

    public final NumberPath<Integer> acptAmt = createNumber("acptAmt", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath rcptDate = createString("rcptDate");

    public final NumberPath<Integer> rcptSeq = createNumber("rcptSeq", Integer.class);

    public final NumberPath<Integer> reprAmt = createNumber("reprAmt", Integer.class);

    public final StringPath resvDate = createString("resvDate");

    public final StringPath resvTime = createString("resvTime");

    public final StringPath stat = createString("stat");

    public final StringPath vehiNo = createString("vehiNo");

    public QRepair(String variable) {
        super(Repair.class, forVariable(variable));
    }

    public QRepair(Path<? extends Repair> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRepair(PathMetadata metadata) {
        super(Repair.class, metadata);
    }

}

