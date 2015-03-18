package aux;

public class StackNode {
    public Node top;
    public int size = 0;

    public StackNode push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;
        return this;
    }

    public Node pop() {
        if(top == null) {
            return null;
        }

        Node aux = top;
        this.top = top.next;
        size--;
        return aux;
    }

    public Node peek() {
        return top;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public StackNode order() {
        StackNode r = new StackNode();
        while(!this.isEmpty()) {
            int tmp = pop().data;
            while(!r.isEmpty() && r.peek().data < tmp) {
                this.push(r.pop().data);
            }
            r.push(tmp);
        }
        return r;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
