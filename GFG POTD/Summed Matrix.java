class Solution {
    static long sumMatrix(long n, long q) {
        // Calculate the starting point for i
        long start = Math.max(1, q - n);
        // Calculate the ending point for i
        long end = Math.min(n, q - 1);
        
        // Check if there are valid cells
        if (start > end) {
            return 0;
        }
        
        // The number of valid cells is the count of valid i values
        return end - start + 1;
    }
}