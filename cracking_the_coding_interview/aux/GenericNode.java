package aux;

public class GenericNode<T> {
    public GenericNode next = null;
    public T data;

    public GenericNode(T d) {
        data = d;
    }

    void appendToTail(T d) {
        GenericNode end = new GenericNode(d);
        GenericNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public String toString() {
        return "[" + data.toString() + "]" + (this.next == null ? "" : this.next.toString());
    }
}
