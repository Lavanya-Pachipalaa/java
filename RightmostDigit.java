public class RightmostDigit {

    /**
     * This method finds the rightmost digit in a given string.
     *
     * @param str The string to find the rightmost digit in.
     * @return The rightmost digit in the string. If no digit is found, return -1.
     */
    public int getRightmostDigit(String str) {

        // TODO: Write your code here
        if(str.isEmpty())
           return -1;
        else
        {
            int digit=-1;
            for(int i=0;i<str.length();i++)
            {
                if(Character.isDigit(str.charAt(i)))
                {
                    digit=Character.getNumericValue(str.charAt(i));
                }
            }
            return digit;
        }
    }
}