class Solution {
    public static String oddEven(String s) {
        int[] frequency = new int[26]; 
        int n = s.length();
        
        // Calculate the frequency of each character in the string
        for (int i = 0; i < n; i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        int x = 0, y = 0;
        
     
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int position = ch - 'a' + 1; // Position in alphabet (1-indexed)
            int freq = frequency[ch - 'a'];
            
            if (position % 2 == 0 && freq % 2 == 0 && freq > 0) {
                // Even position and even frequency
                x++;
            } else if (position % 2 != 0 && freq % 2 != 0) {
                // Odd position and odd frequency
                y++;
            }
        }
        
        // Check if the sum of x and y is even or odd
        if ((x + y) % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}