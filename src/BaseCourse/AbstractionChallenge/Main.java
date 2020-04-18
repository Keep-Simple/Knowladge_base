package BaseCourse.AbstractionChallenge;

public class Main {
    /**
     * Implementing owm LinkList
     * Created abstract class ListItem to describe generic item in out list
     * Created class Node implementing abstract class ListItem
     * Created MyLinkedList that implements interface NodeList that holds basic methods of LinkedList
     * Then created second version - recursive binary data structure (SearchTree)
     */
    public static void main(String[] args) {
        SearchTree list = new SearchTree(null);
        //MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String str = "Kyiv Melbourne Toronto Sydney Kyiv";
        String[] data = str.split(" ");
        for (String i : data)
            list.addItem(new Node(i));
        list.traverse(list.getRoot());
        list.removeItem(new Node("Toronto"));
        list.traverse(list.getRoot());

    }
}
