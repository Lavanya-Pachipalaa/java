// User function Template for Java
class DigitalRoot_repeated_digital_sum {
    static int repeatedSumOfDigits(int N) {
        // code here
        if (N == 0)
            return 0;

        // If result of modulo operation is
        // zero then, the digit sum is 9
        if (N % 9 == 0)
            return 9;
        return (N % 9);
    }
}
