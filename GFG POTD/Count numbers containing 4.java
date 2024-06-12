
class Solution {
    public static int countNumberswith4(int n) {
        int count = 0;
        
        // Iterate through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (containsDigit4(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    // Helper function to check if a number contains the digit '4'
    private static boolean containsDigit4(int num) {
        // Convert the number to a string and check if it contains '4'
        return String.valueOf(num).contains("4");
    }
}