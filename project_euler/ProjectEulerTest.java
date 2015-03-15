import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class ProjectEulerTest {

    ProjectEuler projectEuler = new ProjectEuler();

    @Test
    public void testSumOfMultiplesOf() {
        assertEquals(23, projectEuler.sumOfMultiplesOfXAndYBelowTop(3, 5, 10));
        assertEquals(2318, projectEuler.sumOfMultiplesOfXAndYBelowTop(3, 5, 100));
        assertEquals(23331668, projectEuler.sumOfMultiplesOfXAndYBelowTop(3, 5, 10000));

        // problem
        assertEquals(233168, projectEuler.sumOfMultiplesOfXAndYBelowTop(3, 5, 1000));
    }

    @Test
    public void testSumOfEvenFibonacciTerms() {
        assertEquals(44, projectEuler.sumOfEvenFibonacciTerms(90));

        // problem
        assertEquals(4613732, projectEuler.sumOfEvenFibonacciTerms(4000000));
    }

    @Test
    public void testPrimeFactorsOf() {
         assertEquals(new Long(5), projectEuler.primeFactorsOf(10l).stream().max(Comparator.<Long>naturalOrder()).get());

        // problem
        assertEquals(new Long(6857), projectEuler.primeFactorsOf(600851475143l).stream().max(Comparator.<Long>naturalOrder()).get());
    }

    @Test
    public void testLargestPalindromeProduct() {
        assertEquals(new Long(906609), projectEuler.largestPalindromeProduct(100, 999).product());
        assertEquals(new Long(9009), projectEuler.largestPalindromeProduct(10, 99).product());
    }

    @Test
    @Ignore
    public void testSmallestMultipleForNumbersFrom() {
        assertEquals(new Long(2520), projectEuler.smallestMultipleForNumbersFrom(1,10));
        assertEquals(new Long(232792560), projectEuler.smallestMultipleForNumbersFrom(1,20));
    }

    @Test
    public void testSumSquareDifference() {
        assertEquals(new Integer(2640), projectEuler.sumSquareDifference(1, 10));
        assertEquals(new Integer(25164150), projectEuler.sumSquareDifference(1, 100));
    }

    @Test
    public void test10001stPrime() {
        assertEquals(new Long(13), projectEuler.findPrimeInPosition(6));
        assertEquals(new Long(104743), projectEuler.findPrimeInPosition(10001));
    }

    @Test
    public void testLargestProductInASeries() {
        assertEquals(new Long(5832), projectEuler.largestProductInASeries(4));
        assertEquals(new Long(23514624000l), projectEuler.largestProductInASeries(13));
    }

    @Test
    public void testSpecialPythagoreanTriplet() {
        // a=200 b=375 c=425
        assertEquals(new Long(31875000), projectEuler.specialPythagoreanTriple(1000));
    }

    @Test
    @Ignore
    public void testPrimesSummation() {
        assertEquals(new Long(17), projectEuler.primesSummation(10));
        assertEquals(new Long(142913828922l), projectEuler.primesSummation(2000000));
    }

}