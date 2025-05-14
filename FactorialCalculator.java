public class FactorialCalculator {

    public int calculateFactorial(int number) {
        int factorial=1;
        if(number<0)
          return -1;
        else
        {
            for(int i=1;i<=number;i++)
            {
                factorial=factorial*i;
            }
            return factorial;
        }
    }
}