
class NthTermOfAP {
    public static int nthTermOfAP(int a1, int a2, int n) {
        // code here
        int d=a2-a1;
        return a1+(n-1)*d;
    }
}
