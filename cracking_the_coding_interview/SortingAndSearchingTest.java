import org.junit.Test;

import static org.junit.Assert.*;

public class SortingAndSearchingTest {

    SortingAndSearching ss = new SortingAndSearching();

    @Test
    public void testMerge() {

        int[] a = new int[12];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;
        int[] b = new int[]{2,4,6,8,10,12,14};
        int n = 5;
        int m = 7;
        assertTrue(ArraysAndStrings.compareIntArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14},
                ss.merge(a, b, n, m)));
    }
}