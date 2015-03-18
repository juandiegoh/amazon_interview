import aux.LinkedListNode;
import aux.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {

    MyLinkedList myLinkedList = new MyLinkedList();

    @Test
    public void testRemoveDuplicates() {
        Node n1 = getList();
        assertEquals("1234567", myLinkedList.removeDuplicates(n1).toString());

        Node n0 = new Node(0);
        assertEquals("0", myLinkedList.removeDuplicates(n0).toString());

        Node n10bis = new Node(10);
        Node n10 = new Node(10);
        n10.next = n10bis;
        n10bis.next = null;
        assertEquals("10", myLinkedList.removeDuplicates(n10).toString());

        Node n1NoBuffer = getList();
        assertEquals("1234567", myLinkedList.removeDuplicatesWithoutBuffer(n1NoBuffer).toString());

        Node n0NoBuffer = new Node(0);
        assertEquals("0", myLinkedList.removeDuplicatesWithoutBuffer(n0NoBuffer).toString());

        Node allDups2 = new Node(0);
        Node allDups = new Node(0);
        allDups.next = allDups2;
        allDups2.next = null;
        assertEquals("0", myLinkedList.removeDuplicatesWithoutBuffer(allDups).toString());
    }

    @Test
    public void testFindNthToLastNode() {
        Node list = getList();
        assertEquals("456477", myLinkedList.findNthToLastNode(list, 4).toString());
    }

    @Test
    public void testDeleteNodeFromList()  {
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        Node delete = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        n1.next = n2;
        n2.next = delete;
        delete.next = n4;
        n4.next = n5;
        n5.next = null;

        LinkedListNode linkedListNode = new LinkedListNode(n1);
        assertEquals("12345", linkedListNode.toString());
        myLinkedList.deleteNodeFromList(delete, linkedListNode);
        assertEquals("1245", linkedListNode.toString());
    }

    @Test
    public void testDeleteNode()  {
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        Node delete = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        n1.next = n2;
        n2.next = delete;
        delete.next = n4;
        n4.next = n5;
        n5.next = null;

        LinkedListNode linkedListNode = new LinkedListNode(n1);
        assertEquals("12345", linkedListNode.toString());
        myLinkedList.deleteNode(delete);
        assertEquals("1245", linkedListNode.toString());
    }

    @Test
    public void testDeleteNode2()  {
        Node last = new Node(5);
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = last;
        last.next = null;

        LinkedListNode linkedListNode = new LinkedListNode(n1);
        assertEquals("12345", linkedListNode.toString());
        myLinkedList.deleteNode(last);
        assertEquals("12345", linkedListNode.toString());
    }

    @Test
    public void testDeleteNode3()  {
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node first = new Node(1);
        first.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        LinkedListNode linkedListNode = new LinkedListNode(first);
        assertEquals("12345", linkedListNode.toString());
        myLinkedList.deleteNode(first);
        assertEquals("2345", linkedListNode.toString());
    }

    @Test
    public void testSumInvertedListAsIntegers() {
        Node n1 = myLinkedList.getNodeFromInt(513);
        assertEquals("315", n1.toString());

        Node n2 = myLinkedList.getNodeFromInt(296);
        assertEquals("692", n2.toString());

        assertEquals("908", myLinkedList.sumInvertedListsAsIntegers(n1, n2).toString());
    }

    private Node getList() {
        Node n7bis = new Node(7);
        Node n7 = new Node(7);
        Node n4bis = new Node(4);
        Node n6 = new Node(6);
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        Node n1bis = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n1bis;
        n1bis.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n4bis;
        n4bis.next = n7;
        n7.next = n7bis;
        n7bis.next = null;
        return n1;
    }
}