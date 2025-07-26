// User function Template for Java

class ReverseDigits {
    public int reverseDigits(int n) {
        int reverse=0;
        while(n>0) {
            reverse=reverse*10+n%10;
            n=n/10;
        }
        return reverse;
    }
}