class Solution {
    public static void zigZag(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                // For even index, ensure arr[i] < arr[i+1]
                if (arr[i] > arr[i+1]) {
                    // Swap arr[i] and arr[i+1]
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            } else {
                // For odd index, ensure arr[i] > arr[i+1]
                if (arr[i] < arr[i+1]) {
                    // Swap arr[i] and arr[i+1]
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}