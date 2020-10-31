package automechanicsmall;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public interface RepairRepository extends PagingAndSortingRepository<Repair, Long> {


//    public class RepairRepositoryMain{
//
//        @Autowired
//        private EntityManagerFactory entityManagerFactory;
//
//        public void updateStudent(String rcptDate, String rcptTime) {
//            EntityManager em = entityManagerFactory.createEntityManager();
//            EntityTransaction etx = em.getTransaction(); // 유효성 검사
//
//            etx.begin();
//
//            Query query = em.createQuery("update stat = '1' set Repair where id = 1 " );
//            query.executeUpdate();
//
//            etx.commit(); // DB에 저장 --> UPDATE SET..
//            em.close();
//        }
//
//    }

}