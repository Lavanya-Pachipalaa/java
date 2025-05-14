
import java.util.Arrays;

public class Anagrams {
    public boolean areAnagrams(String str1, String str2) {

        // Write your code here

        if (str1 == null || str2 == null) {
            return false;
        }
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (Arrays.equals(c1, c2)) {
            return true;
        } else {
            return false;
        }
    }

}
