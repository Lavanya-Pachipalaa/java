public class NumberUtils {

    public int getLastDigit(int number) {
        // Write your code here
        if(number<0)
          return -1;
        else
        {
            return number%10;
        }
    }
}