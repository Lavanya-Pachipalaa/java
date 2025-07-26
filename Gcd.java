class Gcd {
    public static int gcd(int a, int b) {
        // code here
        return b==0 ? a: gcd(b,a%b);
    }
}
/*class GfG {

    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        // a is greater
        if (a > b) {
            if (a % b == 0)
                return b;
            return gcd(a - b, b);
        }

        // b is greater
        if (b % a == 0)
            return a;
        return gcd(a, b - a);
    }

    // Driver code
    public static void main(String[] args) {
        int a = 20, b = 28;
        System.out.println(gcd(a, b));
    }
}
*/

/*
import java.io.*;

class GFG {

    static int gcd(int a, int b)
    {
        // Find Minimum of a and b
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }

        // Return gcd of a and b
        return result;
    }

    public static void main(String[] args)
    {
        int a = 20, b = 28;
        System.out.print(gcd(a, b));
    }
}
*/