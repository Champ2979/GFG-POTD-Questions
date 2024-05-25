
class Solution {
    long max_Books(int arr[], int n, int k) {
        long maxBooks = 0;
        long currentBooks = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                currentBooks += arr[i];
            } else {
                currentBooks = 0;
            }
            maxBooks = Math.max(maxBooks, currentBooks);
        }
        
        return maxBooks;
    }
}