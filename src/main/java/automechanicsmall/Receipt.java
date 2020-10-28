package automechanicsmall;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Receipt_table")
@EntityListeners(ReceiptListener.class)
public class Receipt implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String rcptDate;
    private Integer rcptSeq;
    private String vehiNo;
    private String stat;
    private String resvDate;
    private String resvTime;
    private Integer reprAmt;
    private Integer acptAmt;



    @PrePersist
    public void onPrePersist(){

        System.out.println("######################Receipt.java - onPrePersist##############################");

        // 예약요청 연계
        if(this.getStat().equals("RESERVED")) {
            Received received = new Received();
            BeanUtils.copyProperties(this, received);
            received.publishAfterCommit();
        }

        /*
        PayRequested payRequested = new PayRequested();
        BeanUtils.copyProperties(this, payRequested);
        payRequested.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        automechanicsmall.external.Payment payment = new automechanicsmall.external.Payment();
        // mappings goes here
        RepairApplication.applicationContext.getBean(automechanicsmall.external.PaymentService.class).pay(payment);
        */

//        ReceivedCancelled receivedCancelled = new ReceivedCancelled();
//        BeanUtils.copyProperties(this, receivedCancelled);
//        receivedCancelled.publishAfterCommit();


//        Completed completed = new Completed();
//        BeanUtils.copyProperties(this, completed);
//        completed.publishAfterCommit();


    }

    @PostPersist
    public void onPostPersist() {
        System.out.println("######################Receipt.java - onPrePersist##############################");

        // 예약요청 연계
        if (this.getStat().equals("RESERVED")) {

        }
    }

    @PostUpdate
    public void onPostUpdate(){

        System.out.println("######################Receipt.java - PostPersist##############################");

        if(this.getStat().equals("PAYREQUEST")) {
            PayRequested payRequested = new PayRequested();
            BeanUtils.copyProperties(this, payRequested);
            payRequested.publish();

            //Following code causes dependency to external APIs
            // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

            automechanicsmall.external.Payment payment = new automechanicsmall.external.Payment();
            // mappings goes here

            payment.setRcptDate(this.getRcptDate());
            payment.setRcptSeq(this.getRcptSeq().toString());
            payment.setAmt(this.getReprAmt().toString());
            payment.setStat("APPROVED");

            RepairApplication.applicationContext.getBean(automechanicsmall.external.PaymentService.class).pay(payment);
        }

    }

//    @PreUpdate
//    public void onPreUpdate() {
//        System.out.println("######################onPreUpdate##############################");
//    }

//    @PostUpdate
//    public void onPostUpdate() {
//        System.out.println("######################onPostUpdate##############################");
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRcptDate() {
        return rcptDate;
    }

    public void setRcptDate(String rcptDate) {
        this.rcptDate = rcptDate;
    }
    public Integer getRcptSeq() {
        return rcptSeq;
    }

    public void setRcptSeq(Integer rcptSeq) {
        this.rcptSeq = rcptSeq;
    }

    public String getVehiNo() {
        return vehiNo;
    }

    public void setVehiNo(String vehiNo) {
        this.vehiNo = vehiNo;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    public String getResvDate() {
        return resvDate;
    }

    public void setResvDate(String resvDate) {
        this.resvDate = resvDate;
    }
    public String getResvTime() {
        return resvTime;
    }

    public void setResvTime(String resvTime) {
        this.resvTime = resvTime;
    }
    public Integer getReprAmt() {
        return reprAmt;
    }

    public void setReprAmt(Integer reprAmt) {
        this.reprAmt = reprAmt;
    }
    public Integer getAcptAmt() {
        return acptAmt;
    }

    public void setAcptAmt(Integer acptAmt) {
        this.acptAmt = acptAmt;
    }




}
