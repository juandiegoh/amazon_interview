package aux;

public class StackNodeWithMin {
    public NodeWithMin top;

    public StackNodeWithMin push(int data) {
        int min = Math.min(data, min());
        NodeWithMin node = new NodeWithMin(min, data);
        node.next = top;
        top = node;
        return this;
    }

    public int min() {
        return peek().min;
    }

    public NodeWithMin peek() {
        return top;
    }

    public NodeWithMin pop() {
        if (top == null) {
            return null;
        }

        NodeWithMin aux = top;
        this.top = top.next;
        return aux;
    }

    @Override
    public String toString() {
        return "min: " + min() + " data: " + top.toString();
    }
}
