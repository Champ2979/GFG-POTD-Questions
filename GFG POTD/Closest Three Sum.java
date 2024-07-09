class Solution {
    static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);  // Step 1: Sort the array
        int n = array.length;
        int closestSum = Integer.MAX_VALUE;  // Initialize closest sum

        for (int i = 0; i < n - 2; i++) {  // Step 2: Iterate through the array
            int left = i + 1;
            int right = n - 1;

            while (left < right) {  // Step 3: Use two pointers
                int currentSum = array[i] + array[left] + array[right];

                if (currentSum == target) {  // Found the exact target sum
                    return currentSum;
                }

                // Update the closest sum
                if (closestSum == Integer.MAX_VALUE || 
                    Math.abs(target - currentSum) < Math.abs(target - closestSum) ||
                    (Math.abs(target - currentSum) == Math.abs(target - closestSum) && currentSum > closestSum)) {
                    closestSum = currentSum;
                }

                // Adjust pointers based on the current sum
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;  // Step 5: Return the closest sum
    }

    public static void main(String[] args) {
        int[] arr1 = {-7, 9, 8, 3, 1, 1};
        int target1 = 2;
        System.out.println(threeSumClosest(arr1, target1));  // Output: 2

        int[] arr2 = {5, 2, 7, 5};
        int target2 = 13;
        System.out.println(threeSumClosest(arr2, target2));  // Output: 14
    }
}