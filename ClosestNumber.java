class ClosestNumber {
    static int closestNumber(int n, int m) {
        // code here
        int q=n/m;
        int n1=m*q;
        int n2=(n*m)>0 ? (m*(q+1)):(m*(q-1));
        if(Math.abs(n-n1)< Math.abs(n-n2))
          return n1;
        else
          return n2;
    }
}