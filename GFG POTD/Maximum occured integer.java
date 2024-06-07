class Solution {
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        // Create the frequency array
        int[] freq = new int[maxx + 2];
        
        // Apply the difference array technique
        for (int i = 0; i < n; i++) {
            freq[l[i]]++;
            if (r[i] + 1 <= maxx) {
                freq[r[i] + 1]--;
            }
        }
        
        // Compute the prefix sum to get the count of occurrences
        int maxCount = freq[0];
        int maxIndex = 0;
        for (int i = 1; i <= maxx; i++) {
            freq[i] += freq[i - 1];
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}