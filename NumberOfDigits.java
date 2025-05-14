public class NumberOfDigits {

    /**
     * This method calculates and returns the number of digits in a given integer.
     * If the number is negative, it returns -1.
     * If the number is zero, it returns 1 as zero is considered to have one digit.
     * @param number: an integer
     * @return number of digits in number, or -1 if number is negative, or 1 if number is zero.
     */
    public int getNumberOfDigits(int number) {
        // Write your code here
        int count=1;
        if(number<0)
          return -1;
        else
        {
            while(number>=10)
            {
                count++;
                number=number/10;
            }
            return count;
        }
    }
}