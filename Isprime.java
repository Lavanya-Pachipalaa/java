class Isprime {
    static boolean isPrime(int n) {
        // code here
        if(n<=1)
          return false;
        for(int i=2;i*i<=n;i++) {//i<=n normal case
            if(n%i==0)
              return false;
        
        }
        return true;
    }
}