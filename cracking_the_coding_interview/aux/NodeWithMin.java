package aux;

public class NodeWithMin {

    public NodeWithMin next;
    public int data;
    public int min;

    public NodeWithMin(int min, int data) {
        this.min = min;
        this.data = data;
    }

    @Override
    public String toString() {
        return data + (this.next == null ? "" : this.next.toString());
    }
}
