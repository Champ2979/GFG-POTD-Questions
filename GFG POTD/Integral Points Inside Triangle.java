class Solution {
    public long InternalCount(long[] p, long[] q, long[] r) {
        long p1 = p[0], p2 = p[1];
        long q1 = q[0], q2 = q[1];
        long r1 = r[0], r2 = r[1];

        // Calculate the area of the triangle using the determinant method
        long area = Math.abs(p1 * (q2 - r2) + q1 * (r2 - p2) + r1 * (p2 - q2));

        // Calculate the number of boundary points using gcd
        long b1 = gcd(Math.abs(p1 - q1), Math.abs(p2 - q2));
        long b2 = gcd(Math.abs(q1 - r1), Math.abs(q2 - r2));
        long b3 = gcd(Math.abs(r1 - p1), Math.abs(r2 - p2));

        // Calculate the total number of boundary points
        long B = b1 + b2 + b3;

        // Calculate the number of internal points using Pick's Theorem
        long I = (area - B + 2) / 2;

        return I;
    }

    // Helper method to calculate gcd
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        long[] p1 = {0, 0};
        long[] q1 = {0, 5};
        long[] r1 = {5, 0};
        System.out.println(sol.InternalCount(p1, q1, r1)); 

        long[] p2 = {62, -3};
        long[] q2 = {5, -45};
        long[] r2 = {-19, -23};
        System.out.println(sol.InternalCount(p2, q2, r2)); 
    }
}