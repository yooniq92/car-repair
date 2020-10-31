package automechanicsmall.external;

public class Payment {

    private Long id;
    private String rcptDate;
    private Integer rcptSeq;
    private Integer amt;
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

    public Integer getRcptSeq() {
        return rcptSeq;
    }

    public void setRcptSeq(Integer rcptSeq) {
        this.rcptSeq = rcptSeq;
    }

    public String getStat() {
        return stat;
    }
    public void setStat(String stat) {
        this.stat = stat;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }
}
