class Solution {
    int rectanglesInCircle(int r) {
        int count = 0;
        int diameter = 2 * r;
        
        // Check all possible integral width (w) and height (h) combinations
        for (int w = 1; w <= diameter; w++) {
            for (int h = 1; h <= diameter; h++) {
                if (w * w + h * h <= diameter * diameter) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.rectanglesInCircle(1)); 
        System.out.println(sol.rectanglesInCircle(2));  
    }
}
