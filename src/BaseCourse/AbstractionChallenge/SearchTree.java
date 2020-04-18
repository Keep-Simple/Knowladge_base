package BaseCourse.AbstractionChallenge;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) { //tree is empty
            this.root = newItem;
            return true;

        } else { //start comparison form the head of the tree
            ListItem currentItem = this.root;
            while (this.root != null) {
                int comparison = currentItem.compareTo(newItem);

                if (comparison < 0) {  //newItem is greater, move as right as possible
                    if (currentItem.next() != null)
                        currentItem = currentItem.next();
                    else { //add node
                        currentItem.setRight(newItem);
                        return true;
                    }
                } else if (comparison > 0) { //newItem is lower, move as left as possible
                    if (currentItem.previous() != null)
                        currentItem = currentItem.next();
                    else { //add node
                        currentItem.setLeft(newItem);
                        return true;
                    }
                } else { //newItem is equal to current, no need in adding node
                    System.out.println("Node already exists");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null)
            System.out.println("Deleting :" + item.getValue());
        ListItem currentItem = this.root;
        ListItem parent = currentItem;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parent = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parent = currentItem;
                currentItem = currentItem.previous();
            } else { //item found
                performRemoval(currentItem, parent);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) { // RIGHT NODE FOR ITEM IS ABSENT
            if (parent.next() == item) { //node was right one to parent
                parent.setRight(item.previous());
            } else if (parent.previous() == item) { //node was left one to parent
                parent.setLeft(item.previous());
            } else { //parent == item, delete root
                this.root = item.previous();
            }
        } else if (item.previous() == null) { //LIFT NODE FOR ITEM IS ABSENT
            if (parent.next() == item) { //node was right one to parent
                parent.setRight(item.next());
            } else if (parent.previous() == item) { //node was left one to parent
                parent.setLeft(item.next());
            } else { //parent == item, delete root
                this.root = item.next();
            }
        } else { //NODE HAS TWO CHILD
            //finding leftmost(smallest) value from fright subtree
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            //setting value of leftmost to item we want to delete
            item.setValue(current.getValue());
            //and delete the leftmost
            if (item == leftmostParent) { //this is the case when right sub-tree doesn't have first left child
                leftmostParent.setRight(current.next());
            } else { //leftmostParent must point (setLeft) to right child of leftmost. this may leftmost will be deleted
                leftmostParent.setLeft(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        //recursive
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
