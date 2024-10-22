public class StringMatching {
    
    // Function to find all occurrences of pattern in text
    public static void searchString(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        // Loop through the text to check each substring of length equal to pattern
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            // Check if the current substring matches the pattern
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break; // If there's a mismatch, break the inner loop
                }
            }

            // If the inner loop didn't break, then a match is found
            if (j == patternLength) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        
        // Call the searchString function to find pattern in text
        searchString(text, pattern);
    }
}
