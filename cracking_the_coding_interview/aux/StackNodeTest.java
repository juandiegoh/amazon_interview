package aux;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackNodeTest {

    @Test
    public void testOrder() {
        StackNode s = new StackNode();
        s.push(8);
        s.push(1);
        s.push(5);
        s.push(3);
        s.push(2);

        StackNode ordered = s.order();
        assertEquals(1, ordered.pop().data);
        assertEquals(2, ordered.pop().data);
        assertEquals(3, ordered.pop().data);
        assertEquals(5, ordered.pop().data);
        assertEquals(8, ordered.pop().data);
    }
}