import java.util.*;
import java.util.stream.Stream;

public class PrimeNumbers {

    private List<Long> primes = new LinkedList<>();
    private Long counter = 2l;

    public Long next() {
        while(divisibleByPreviousPrime(counter)) {
            counter++;
        }
        Long result = counter;
        primes.add(result);
        counter++;
        return result;
    }

    private boolean divisibleByPreviousPrime(long number) {
        Stream<Long> divisors = primes.stream().filter(p -> number % p == 0).limit(1);
        return divisors.count() != 0;
    }
}
