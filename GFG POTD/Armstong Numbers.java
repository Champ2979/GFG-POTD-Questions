class Solution {
    static String armstrongNumber(int n) {
        int originalNumber = n;
        int sum = 0;
        
        // Extracting digits and calculating the sum of their cubes
        while (n > 0) {
            int digit = n % 10; // get the last digit
            sum += Math.pow(digit, 3); // add the cube of the digit to sum
            n /= 10; // remove the last digit
        }
        
        // Compare the sum of cubes to the original number
        if (sum == originalNumber) {
            return "true";
        } else {
            return "false";
        }
    }
}
