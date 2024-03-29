package automechanicsmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/repairs")
public class RepairController  {

    //GET 정상 작동1
//    @GetMapping("/{id}")
//    public void cancel(@RequestBody Repair repair, @PathVariable("id") int id) {
//        System.out.println("###########RepairController.java - RepairController##############");
//        System.out.println(id);
//        System.out.println(id);
//    }

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/cancel")
    public void cancel(@RequestParam("rcptDate") String rcptDate, @RequestParam("rcptTime") String rcptTime) {

        System.out.println("###########RepairController.java - RepairController ##############");
        //System.out.println(rcptDate);
        //System.out.println(rcptTime);

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction etx = em.getTransaction(); // 유효성 검사

        etx.begin();

        String queryString = " UPDATE Repair\n"+
                             "    SET stat = 'CANCELLED'\n"+
                             "  WHERE RESV_DATE = '"+rcptDate+"'\n"+
                             "    AND RESV_TIME = '"+rcptTime+"'  ";

        Query query = em.createQuery(queryString);
        query.executeUpdate();

        etx.commit(); // DB에 저장 --> UPDATE SET..
        em.close();

    }

}
