package aux;

public class QueueNode {

    public Node first;
    public Node last;

    public QueueNode push(Node node) {
        if(first == null) {
            this.first = node;
            this.last = this.first;
        } else {
            node.next = last;
            this.last = node;
        }
        return this;
    }

    public Node pop() {
        if(first == null) {
            return null;
        }

        Node aux = first;
        this.first = first.next;
        return aux;
    }
}
