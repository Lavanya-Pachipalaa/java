import java.io.*;

class NthTermOf1_3_6_10_15_21___ {

    // Function to find nth term
    static int term(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(term(n));
    }
}