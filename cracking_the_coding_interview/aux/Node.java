package aux;

public class Node {
    public Node next = null;
    public int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public String toString() {
        return data + (this.next == null ? "" : this.next.toString());
    }
}