class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is the point of divergence
            if (mid < n - 1 && arr1[mid] == arr2[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        return left;
    }
}