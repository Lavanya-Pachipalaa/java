public class LongestWord {

    /**
     * This method finds the longest word in a given sentence.
     *
     * @param sentence The sentence to find the longest word in.
     * @return The longest word in the sentence. If sentence is empty, return an empty string.
     */
    public String findLongestWord(String sentence) {

        // TODO: Write your code here
        String[] words=sentence.split(" ");
        String longest="";
        for(String word:words)
        {
            if(longest.length()<word.length())
              longest=word;
        }
        return longest;
    }
}