import java.util.List;

public class SumOfNumbers {

    public static long sumOfSquares(List<Integer> numbers) {

        // Check if the list is null. If so, return 0.

        // Stream over the list of numbers, find squares and sum them up
        if (numbers == null || numbers.size() == 0)
            return 0;
        return numbers.stream().mapToLong(n -> n * n).sum();

    }

}