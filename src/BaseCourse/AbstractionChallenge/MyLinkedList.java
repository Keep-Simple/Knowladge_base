package BaseCourse.AbstractionChallenge;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) { //new item is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else { //if no next, insert at the end
                    currentItem.setRight(newItem).setLeft(currentItem);
                    return true;
                }
            } else if (comparison > 0) { //new item is lower, insert before current
                if (currentItem.previous() != null) {
                    currentItem.previous().setRight(newItem);
                    newItem.setLeft(currentItem.previous());
                    newItem.setRight(currentItem);
                    currentItem.setLeft(newItem);
                } else { //node without prev is root, insert before root
                    newItem.setRight(this.root);
                    this.root.setLeft(newItem);
                    this.root = newItem;
                }
                return true;
            } else { //equal
                System.out.println(newItem.getValue() + " is already exists");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null)
            System.out.println("Deleting item : " + item.getValue());

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {//found
                //in case it was root
                if (currentItem == this.root)
                    this.root = currentItem.next();
                else {
                    currentItem.previous().setRight(currentItem.next());
                    if (currentItem.next() != null)
                        currentItem.next().setLeft(currentItem.previous());
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else { // comparison>0, that possible only when item isn't
                // presented in the list
                System.out.println("Unable to delete. Item isn't in the list");
                return false;
            }
        }
        System.out.println("Unable to delete. Item isn't in the list");
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null)
            System.out.println("List is empty");
        else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
