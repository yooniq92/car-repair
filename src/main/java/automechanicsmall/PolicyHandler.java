package automechanicsmall;

import automechanicsmall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    RepairRepository repairRepository;

    // requestRepair
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_RequestRepair(@Payload Reserved reserved){

        if(reserved.isMe()){

            System.out.println("##### listener RequestRepair : " + reserved.toJson());

            Repair repair = new Repair();
            repair.setResvDate(reserved.getResvDate());
            repair.setResvTime(reserved.getResvTime());
            repair.setVehiNo(reserved.getVehiNo());
            repair.setStat("RESERVED");

            repairRepository.save(repair);

        }
    }

    //requestComploete
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentApproved_RequestComplete(@Payload PaymentApproved paymentApproved){

        if(paymentApproved.isMe()){
            System.out.println("##### listener RequestComplete : " + paymentApproved.toJson());

            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction etx = em.getTransaction(); // 유효성 검사

            etx.begin();

            String queryString = " UPDATE Repair\n"+
                                 "    SET stat = 'PAYAPPROVED',\n"+
                                 "        ACPT_AMT = '"+paymentApproved.getAmt()+"'\n"+
                                 "  WHERE RCPT_DATE = '"+paymentApproved.getRcptDate()+"'\n"+
                                 "    AND RCPT_SEQ = '"+paymentApproved.getRcptSeq()+"'  ";

            Query query = em.createQuery(queryString);
            query.executeUpdate();

            etx.commit(); // DB에 저장 --> UPDATE SET..
            em.close();

        }
    }

}
