package aux;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetOfStacksTest {

    @Test
    public void testSetOfStacksTest() {
        SetOfStacks setOfStacks = new SetOfStacks();
        assertNull(setOfStacks.pop());

        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        assertEquals("[3]", setOfStacks.toString());

        setOfStacks.push(4);
        assertEquals("[4]", setOfStacks.toString());

        Node n4 = setOfStacks.pop();
        assertEquals(4, n4.data);
        assertEquals("[3]", setOfStacks.toString());

        setOfStacks.push(4);
        assertEquals("[4]", setOfStacks.toString());

        setOfStacks.push(5);
        assertEquals("[3][2]", setOfStacks.toString());
        assertEquals(5, setOfStacks.peek().data);

        setOfStacks.push(6);
        setOfStacks.push(7);
        assertEquals("[3][2][2]", setOfStacks.toString());

        Node n = setOfStacks.pop();
        assertEquals(7, n.data);
        n = setOfStacks.pop();
        assertEquals(6, n.data);
        n = setOfStacks.pop();
        assertEquals(5, n.data);
        assertEquals("[0][2][2]", setOfStacks.toString());

        n = setOfStacks.pop();
        assertEquals(4, n.data);
        assertEquals("[1][2]", setOfStacks.toString());

        n = setOfStacks.pop();
        assertEquals(3, n.data);
        n = setOfStacks.pop();
        assertEquals(2, n.data);
        n = setOfStacks.pop();
        assertEquals(1, n.data);
        assertEquals("[0]", setOfStacks.toString());
    }
}