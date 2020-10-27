package automechanicsmall.external;

public class Payment {

    private Long id;
    private String rcptDate;
    private String rcptSeq;
    private String amt;
    private String stat;

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
    public String getRcptSeq() {
        return rcptSeq;
    }
    public void setRcptSeq(String rcptSeq) {
        this.rcptSeq = rcptSeq;
    }
    public String getAmt() {
        return amt;
    }
    public void setAmt(String amt) {
        this.amt = amt;
    }
    public String getStat() {
        return stat;
    }
    public void setStat(String stat) {
        this.stat = stat;
    }

}
