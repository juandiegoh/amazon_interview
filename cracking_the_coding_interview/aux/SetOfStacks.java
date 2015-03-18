package aux;

public class SetOfStacks {
    private static final int SIZE_LIMIT = 4;
    private static final int SPLIT_SIZE = 2;
    GenericNode<StackNode> stackList = null;

    public Node pop() {
        if(stackList == null) {
            return null;
        }

        Node node = stackList.data.pop();
        if(node != null) {
            return node;
        } else { // check if we have to look on the next stackList
            if(stackList.next != null) {
                // delete this stackList and use the next one
                this.stackList = stackList.next;
                return this.stackList.data.pop();
            } else {
                return null;
            }
        }
    }

    public void push(int data) {
        if(stackList == null) {
            StackNode newStack = new StackNode();
            newStack.push(data);
            stackList = new GenericNode<>(newStack);
        } else {
            if(stackList.data.size >= SIZE_LIMIT) {
                splitStack();
                this.stackList.data.push(data);
            } else {
                this.stackList.data.push(data);
            }
        }
    }

    private void splitStack() {
        StackNode newStack = new StackNode();
        StackNode bufferStack = new StackNode();

        while(stackList.data.size > SPLIT_SIZE) {
            Node n = stackList.data.pop();
            bufferStack.push(n.data);
        }

        while(!bufferStack.isEmpty()) {
            Node n = bufferStack.pop();
            newStack.push(n.data);
        }

        GenericNode<StackNode> newSplitStack = new GenericNode<>(newStack);
        newSplitStack.next = this.stackList;
        this.stackList = newSplitStack;
    }

    public Node peek() {
        if(stackList != null) {
            return stackList.data.peek();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.stackList.toString();
    }
}
