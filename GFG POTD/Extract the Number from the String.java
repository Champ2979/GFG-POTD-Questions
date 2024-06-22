class Solution {
    long ExtractNumber(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        long maxNumber = -1;

        // Loop through each word
        for (String word : words) {
            // Check if the word is a number and does not contain '9'
            if (isNumber(word) && !word.contains("9")) {
                long number = Long.parseLong(word);
                // Update maxNumber if the current number is greater
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
        }

        return maxNumber;
    }

    // Helper method to check if a string is a valid number
    boolean isNumber(String word) {
        // Check if the string consists only of digits
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.ExtractNumber("This is alpha 5057 and 97")); // Output: 5057
        System.out.println(sol.ExtractNumber("Another input 9007")); // Output: -1
    }
}
