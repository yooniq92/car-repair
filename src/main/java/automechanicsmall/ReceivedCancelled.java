package automechanicsmall;

public class ReceivedCancelled extends AbstractEvent {

    private Long id;

    public ReceivedCancelled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
