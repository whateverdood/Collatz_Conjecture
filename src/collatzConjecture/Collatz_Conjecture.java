/**
 * Problem #3: Java Classes
 * Use your Java skills to write a class that can compute the value of the of the Collatz Conjecture for values from 1 to 30.
 * Design the class such that it prints the input values, and the various intermediate values computed.
 * E.g.:
 * given n = 28
 * the code should produce: 28,14,7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,
 *
 * given n = 29
 * produced sequence: 29,88,44,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,
 * <p>
 * Use good commenting and code style, and use the Eclipse Java formatter to indent your code.
 */
package collatzConjecture;

import java.util.ArrayList;
import java.util.List;

public class Collatz_Conjecture {

    /**
     * Computes the Collatz Conjecture for the given positive integer.
     * @return The computed sequence.
     */
    public List<Integer> computeSequence(Integer startingTerm) {
        if (startingTerm <= 0) {
            throw new IllegalArgumentException("Starting integer must be positive");
        }

        List<Integer> sequence = new ArrayList<>();
        sequence.add(startingTerm);

        Integer nextTerm = computeNextTerm(startingTerm);
        while (nextTerm > 1) {
            sequence.add(nextTerm);
            nextTerm = computeNextTerm(nextTerm);
        }

        return sequence;
    }

    private Integer computeNextTerm(Integer term) {
        if (term % 2 == 0) {
            return term / 2;
        } else {
            return term * 3 + 1;
        }
    }

    /**
     * Main test driver.
     * @param args
     */
    public static void main(String[] args) {

        Collatz_Conjecture collatz = new Collatz_Conjecture();

        for (Integer i = 1; i <= 30; i++) {
            System.out.println("n = " + i);
            System.out.println(collatz.computeSequence(i));
        }
    }

}
