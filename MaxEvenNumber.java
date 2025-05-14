import java.util.List;
import java.util.Optional;

public class MaxEvenNumber {

    public static int findMaxEvenNumber(List<Integer> numbers) {
        // Write your code here
        if (numbers == null || numbers.size() == 0)
            return 0;
        return numbers.stream().filter(n -> n % 2 == 0).max(Integer::compare).orElse(0);
    }
}