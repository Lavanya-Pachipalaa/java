public class ReverseNumber {

    /**
     * This method reverses a given integer and returns the reversed number.
     * If the number is negative, it returns -1 as the reverse of a negative number is undefined.
     * If the number is zero, it returns 0 as the reverse of 0 is 0.
     * @param number: an integer
     * @return reversed number, or -1 if number is negative, or 0 if number is zero.
     */
    public int reverseNumber(int number) {
        // TODO: Write your code here
        int reverse=0;
        if(number<0)
          return -1;
        else
        {
            while(number>0)
            {
                int m=number%10;
                reverse=reverse*10+m;
                number=number/10;
            }
            return reverse;
        }
        
    }
}