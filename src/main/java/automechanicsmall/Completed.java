package automechanicsmall;

public class Completed extends AbstractEvent {

    private Long id;

    public Completed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
