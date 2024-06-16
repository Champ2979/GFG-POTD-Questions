class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (prime[i] && prime[n - i]) {
                ans.add(i);
                ans.add(n - i);
                return ans;
            }
        }

        ans.add(-1);
        ans.add(-1);
        return ans;
    } 
    
    public static void main(String[] args) {
        int n = 8;
        ArrayList<Integer> result = getPrimes(n);
        System.out.println(result.get(0) + " " + result.get(1)); // Expected Output: 3 5
    }
}