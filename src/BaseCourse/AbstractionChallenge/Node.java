package BaseCourse.AbstractionChallenge;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.right;
    }

    @Override
    ListItem setRight(ListItem item) {
        this.right = item;
        return this.right;
    }

    @Override
    ListItem previous() {
        return this.left;
    }

    @Override
    ListItem setLeft(ListItem item) {
        this.left = item;
        return this.left;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null)
            return ((String) super.getValue()).compareTo((String) item.getValue());
        else
            return -1;
    }
}
