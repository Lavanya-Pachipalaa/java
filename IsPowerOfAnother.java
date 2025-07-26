// User function Template for Java
class IsPowerOfAnother {
    public boolean isPowerOfAnother(int X, int Y) {
        if (X <= 1 || Y <= 0) 
            return false;
        double k = Math.log(Y) / Math.log(X);
        return Math.abs(k - Math.round(k)) < 1e-10;
    
    }
}
