package basics.BaseCourse.AbstractionChallenge;

public abstract class ListItem {
    protected ListItem left = null;
    protected ListItem right = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();

    abstract ListItem setRight(ListItem item);

    abstract ListItem previous();

    abstract ListItem setLeft(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
