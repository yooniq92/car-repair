package automechanicsmall;

public class RepairedCancelled extends AbstractEvent {

    private Long id;

    public RepairedCancelled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
