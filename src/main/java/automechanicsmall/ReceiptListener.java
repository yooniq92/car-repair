package automechanicsmall;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

public class ReceiptListener {

    @Autowired
    private ReceiptRepository receiptRepository;

    @PrePersist
    public void onPrePersistListener(Receipt receipt) throws Exception {

        System.out.println("######################ReceiptListener.java - onPrePersistListener##############################");

        if(receipt.getStat().equals("RESERVED")) {
            // 예약정보 넘겨 받은 후 접수번호 생성
            try {

                EntityManager em = BeanUtil.getBean(EntityManager.class);

                String queryString = "";

                queryString = " SELECT NVL(MAX(rcpt_seq),0)+1 FROM Receipt where rcpt_date = '" + receipt.getResvDate() + "'\n";

                System.out.println(queryString);

                Object object = em.createQuery(queryString).getSingleResult();

                receipt.setRcptDate(receipt.getResvDate());
                receipt.setRcptSeq(Integer.parseInt(object.toString()));

                em.close();

            } catch (Exception e) {
                throw new Exception("접수번호 생성시 오류가 발생하였습니다.");
            } finally {

            }
        }

    }
}
