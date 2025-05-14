public class SumOfDigits {

    public int getSumOfDigits(int number) {
        // Write your code here
        int sum=0;
        if(number<0)
          return -1;
        else
        {
            while(number>0)
            {
                int m=number%10;
                sum=sum+m;
                number=number/10;
            }
            return sum;
        }
    }
}