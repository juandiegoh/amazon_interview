package aux;

public class NodeStack {
    public NodeStack next;
    public StackNode data;

    public NodeStack(StackNode stackNode) {
        this.data = stackNode;
    }
}
