public class WordReverser {

    public String reverseWordsInSentence(String sentence) {
        // TODO: Check if the sentence is null.
        // If the sentence is null, return "INVALID"
        if (sentence == null)
            return "INVALID";

        // TODO: Check if the sentence is empty.
        // If the sentence is empty, return an empty string
        if (sentence.isEmpty())
            return sentence;
        // TODO: Split the sentence into words using the split method.
        // Use " " as the delimiter to match space.
        String[] words = sentence.split(" ");
        StringBuilder reverse = new StringBuilder();

        for (String word : words) {
            StringBuilder str = new StringBuilder(word);
            reverse.append(str.reverse() + " ");
        }
        String reversed = new String(reverse);

        return reversed.trim();

        // TODO: Create a StringBuilder to hold the reversed sentence.

        // TODO: Loop through each word in the words array.

        // TODO: For each word, create a StringBuilder and reverse the word.
        // Append the reversed word, followed by a space, to the reversed sentence.

        // TODO: After reversing all the words, trim the trailing space and return the
        // reversed sentence.

    }
}