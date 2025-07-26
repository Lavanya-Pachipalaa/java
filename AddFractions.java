import java.util.ArrayList;
import java.util.List;

public class AddFractions {
    // Function to find gcd of a and b
    public static int gcd(int n1, int n2) {
        if (n1 == 0)
            return n2;
        return gcd(n2 % n1, n1);
    }

    // Function to add two fractions
    public static List<Integer> addFraction(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();
        // Finding gcd of den1 and den2
        int den = gcd(a.get(1), b.get(1));

        // Denominator of final fraction obtained
        // finding LCM of den1 and den2
        // LCM * GCD = a * b
        den = (a.get(1) * b.get(1)) / den;

        // Changing the fractions to have same denominator
        // Numerator of the final fraction obtained
        int num = (a.get(0)) * (den / a.get(1)) + (b.get(0)) * (den / b.get(1));

        // finding the common factor of numerator and denominator
        int common_factor = gcd(num, den);

        // Converting the result into simpler
        // fraction by dividing them with common factor
        den = den / common_factor;
        num = num / common_factor;
        ans.add(num);
        ans.add(den);
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(2);
        List<Integer> ans = addFraction(a, b);
        System.out.println(ans.get(0) + ", " + ans.get(1));
    }
}