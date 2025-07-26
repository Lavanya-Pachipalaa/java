import java.util.*;

class DecToBinary {

    static String decToBinary(int n) {
        // String to store the binary representation
        StringBuilder bin = new StringBuilder();

        while (n > 0) {

            // Finding (n % 2) using bitwise AND operator
            // (n & 1) gives the least significant bit (LSB)

            int bit = n & 1;
            bin.append(bit);

            // Right shift n by 1 (equivalent to n = n / 2)
            // This removes the least significant bit (LSB)

            n = n >> 1;
        }

        return bin.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(decToBinary(n));
    }
}
/*
 * static String decToBinary(int n) {
 * int len = (int)(Math.log(n) / Math.log(2));
 * // Convert to binary string and remove leading zeros
 * return String.format("%s", Integer.toBinaryString(n));
 * }
 */