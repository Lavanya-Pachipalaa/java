public class ArraySorted {

    /**
     * This method checks if the input array is sorted in ascending order.
     * 
     * @param array the array to check
     * @return true if the array is sorted, false otherwise
     */
    public boolean isSorted(int[] array) {

        // TODO: Write code here
        int flag=0;
        if(array.length<=1)
          return true;
        else
        {
            for(int i=0;i<array.length-1;i++)
            {
                flag=0;
                if(array[i]<=array[i+1])
                   flag=1;
                else 
                  break;
            }
            if(flag==1)
               return true;
        }
        return false;
    }
}