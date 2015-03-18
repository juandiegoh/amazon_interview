import aux.LinkedListNode;
import aux.Node;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedList {

    /**
     * 2.1 Write code to remove duplicates from an unsorted linked list FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    public Node removeDuplicates(Node node) {
        Set<Integer> buffer = new HashSet<>();
        Node head = node;
        Node n = node;
        while (n != null) {
            buffer.add(n.data);
            if (n.next != null) {
                if (buffer.contains(n.next.data)) {
                    n.next = n.next.next;
                }
            }
            n = n.next;
        }
        return head;
    }

    public Node removeDuplicatesWithoutBuffer(Node node) {
        Node head = node;
        Node n = node;
        while (n != null) {
            Node before = n;
            Node now = n.next;
            while (now != null) {
                if (n.data == now.data) {
                    before.next = now.next;
                    now = now.next;
                } else {
                    before = now;
                    now = now.next;
                }
            }
            n = n.next;
        }
        return head;
    }

    /**
     * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
     *
     * @param head
     * @param d
     * @return
     */
    public Node findNthToLastNode(Node head, int d) {
        if (head == null || head.data == d) {
            return head;
        }
        Node n = head.next;
        while (n != null) {
            if (n.data == d) {
                return n;
            } else {
                n = n.next;
            }

        }
        return head; // what happens if d does not exist?
    }

    /**
     * 2.3 _ Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
     * EXAMPLE
     * Input: the node ‘c’ from the linked list a->b->c->d->e
     * Result: nothing is returned, but the new linked list looks like a->b->d->e
     */
    public void deleteNodeFromList(Node d, LinkedListNode list) {
        if (list.head == null || list.head == d) {
            list.clear();
        }

        Node previous = list.head;
        Node n = list.head.next;
        while (n != null) {
            if (n == d) {
                previous.next = n.next;
                return;
            } else {
                previous = n;
                n = n.next;
            }

        }
    }

    /**
     * 2.3 BIS _ Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
     * EXAMPLE
     * Input: the node ‘c’ from the linked list a->b->c->d->e
     * Result: nothing is returned, but the new linked list looks like a->b->d->e
     */
    public void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
        return;
    }

    /**
     * You have two numbers represented by a linked list, where each node contains a sin- gle digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
     * EXAMPLE
     * Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
     */
    public Node sumInvertedListsAsIntegers(Node n1, Node n2) {
        int n1Value = getListValue(n1);
        int n2Value = getListValue(n2);


        int result = n1Value + n2Value;
        if (result > 0) {

            return getNodeFromInt(result);
        }
        return null;
    }

    public Node getNodeFromInt(int result) {
        int division = result / 10;
        int remainder = result % 10;
        Node head = new Node(remainder);
        Node previous = head;

        remainder = division % 10;
        division = division / 10;
        while (division != 0 || remainder != 0) {
            Node n = new Node(remainder);
            previous.next = n;
            previous = n;
            remainder = division % 10;
            division = division / 10;
        }
        return head;
    }

    private int getListValue(Node n) {
        int pow = 0;
        int sum = 0;
        while (n != null) {
            sum += (n.data * pow(10, pow));
            pow++;
            n = n.next;
        }
        return sum;
    }

    private int pow(int num, int count) {
        if (count <= 0) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i <= count; i++) {
            result *= num;
        }
        return result;
    }
}
