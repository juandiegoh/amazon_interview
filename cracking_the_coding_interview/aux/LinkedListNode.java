package aux;

public class LinkedListNode {
    public Node head;

    public LinkedListNode(Node head) {
        this.head = head;
    }

    public void clear() {
        this.head = null;
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
