public class SecondLargestElement {
    
    /**
     * This method finds and returns the second largest element in the given array.
     * 
     * @param array the array in which to find the second largest element
     * @return the second largest element in the array
     */
     
    public int findSecondLargestElement(int[] array) {
        //TODO: Write your code here
        if(array.length<2)
          return -1;
        else
        {
            int largest=Integer.MIN_VALUE;
            int secondLargest=Integer.MIN_VALUE;
            for(int a:array)
            {
                if(a>largest)
                {
                    secondLargest=largest;
                    largest=a;
                }
                else if(a>secondLargest && a!=largest)
                   secondLargest=a;
            }
            if(secondLargest==Integer.MIN_VALUE)
               return -1;
            return secondLargest;
        }
        
    }
}