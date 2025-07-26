// User function Template for Java
class ValidTriangle {
    public boolean checkValidity(int a, int b, int c) {
        // code here
        if((a+b)<=c || (b+c)<=a || (c+a)<=b)
           return false;
        return true;
    }
}