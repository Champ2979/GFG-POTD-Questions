class Solution {

    double maxVolume(double perimeter, double area) {
        double P = perimeter;
        double A = area;
        
        // Calculating l and w from the given perimeter and area formulas
        double l = (P - Math.sqrt(P * P - 24 * A)) / 12;
        
        // Calculating the height
        double height = (P / 4) - 2 * l;
        
        // Calculating the volume
        double ans = l * l * height;
        
        // Rounding to 2 decimal places
        return Math.round(ans * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxVolume(22, 15));  // Output: 3.02
        System.out.println(sol.maxVolume(20, 5));   // Output: 0.33
    }
}
