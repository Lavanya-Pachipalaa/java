import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

public class CubesOfNumbers {

    /**
     * This method generates the cubes of the first n natural numbers.
     * 
     * @param n The number of natural numbers for which cubes are to be calculated.
     * @return List<Integer> This returns a list of cubes of the first n natural
     *         numbers.
     */
    public static List<Integer> getCubesOfFirstNNumbers(int n) {
        // Write your code here
        if (n == 0)
            return List.of();
        return IntStream.range(1, n + 1).map(c -> c * c * c).boxed().collect(Collectors.toList());

    }
}