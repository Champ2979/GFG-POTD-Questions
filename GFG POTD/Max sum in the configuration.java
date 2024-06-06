class Solution {
    long max_sum(int a[], int n) {
        // Calculate sumA (sum of all elements in the array)
        long sumA = 0;
        for (int i = 0; i < n; i++) {
            sumA += a[i];
        }
        
        // Calculate the initial S value
        long currentS = 0;
        for (int i = 0; i < n; i++) {
            currentS += i * a[i];
        }
        
        // Initialize maxS with the initial S value
        long maxS = currentS;
        
        // Calculate S for other rotations and find the maximum S
        for (int i = 1; i < n; i++) {
            currentS = currentS - sumA + n * a[i - 1];
            if (currentS > maxS) {
                maxS = currentS;
            }
        }
        
        return maxS;
    }
}
