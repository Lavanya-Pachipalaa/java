class Lcm {
    public int lcm(int a, int b) {
        // code here
        int l=Math.max(a,b);
        int s=Math.min(a,b);
        int i=l;
        while(i<=a*b) {
            if(i%s==0)
              return i;
            i+=l;
        }
        return a*b;
    }
}
/*
class GfG {
    
    // function for gcd 
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println(lcm(a, b)); 
    }
}
*/