class PerfectNumber {
    static boolean isPerfect(int n) {
        // code here
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n)
                    sum += i;
                sum = sum + i + (n / i);
            }
        }
        return n == sum;
    }
};
/*
 * public class GFG {
 * 
 * // Function to check if the number is perfect
 * public static boolean isPerfect(int n) {
 * int sum = 0;
 * for (int i = 1; i < n; i++) {
 * if (n % i == 0) {
 * sum += i;
 * }
 * }
 * return sum == n;
 * }
 * 
 * public static void main(String[] args) {
 * int n = 15;
 * System.out.println(isPerfect(n) ? "true" : "false");
 * }
 * }
 */