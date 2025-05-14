public class SumsEqual {

    private int[] array1;
    private int[] array2;

    public SumsEqual(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public boolean areSumsEqual() {

        int sum1 = calculateSum(array1);
        int sum2 = calculateSum(array2);
        if(sum1==sum2)
           return true;
        else
           return false;

        // TODO: Write the code to compare the sums of the arrays and return the result.
    }

    private int calculateSum(int[] array) {
        
        // TODO: Write the code to calculate the sum of the array.
        int sum=0;
        for(int a:array)
           sum+=a;
        return sum;

    }
}