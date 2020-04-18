package basics.BaseCourse.Concurrency._9;

public class SharedResource {

    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }


}
