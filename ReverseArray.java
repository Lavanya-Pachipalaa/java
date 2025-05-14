public class ReverseArray {

    /**
     * This method reverses an array.
     * 
     * @param array the array to reverse
     * @return a new array with elements in reverse order
     */
    public int[] reverseArray(int[] array) {

        // TODO: Write your code here
        int[] array2=new int[array.length];
        if(array.length<=1)
           return array;
        else
        {
            int start=0;
            int end=array.length-1;
            while(start<=end)
            {
                array2[start]=array[end];
                array2[end]=array[start];
                start++;
                end--;
            }
            return array2;
        }
        
    }
}