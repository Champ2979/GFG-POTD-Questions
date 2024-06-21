import java.util.*;
class CompareTwoFractions{

    String compareFrac(String str) {
        // Split the input string by comma and space to get the two fractions
        String[] fractions = str.split(", ");
        
        // Split the first fraction to get numerator and denominator
        String[] firstFraction = fractions[0].split("/");
        int a = Integer.parseInt(firstFraction[0]);
        int b = Integer.parseInt(firstFraction[1]);
        
        // Split the second fraction to get numerator and denominator
        String[] secondFraction = fractions[1].split("/");
        int c = Integer.parseInt(secondFraction[0]);
        int d = Integer.parseInt(secondFraction[1]);
        
        // Compare a/b and c/d by cross-multiplying to avoid floating-point issues
        long leftSide = (long) a * d; // a*d
        long rightSide = (long) c * b; // c*b
        
        if (leftSide > rightSide) {
            return fractions[0];
        } else if (leftSide < rightSide) {
            return fractions[1];
        } else {
            return "equal";
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.compareFrac("5/6, 11/45")); 
        System.out.println(sol.compareFrac("8/1, 8/1")); 
        System.out.println(sol.compareFrac("10/17, 9/10")); 
    }
}