class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // Array to store orders with their respective index and tip difference
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            orders[i] = new Order(i, arr[i], brr[i], Math.abs(arr[i] - brr[i]));
        }

        // Sort orders by the absolute difference in descending order
        Arrays.sort(orders, (o1, o2) -> o2.diff - o1.diff);

        long totalTip = 0;
        int countA = 0, countB = 0;

        // Iterate through sorted orders and assign them
        for (Order order : orders) {
            if ((order.tipA >= order.tipB && countA < x) || countB == y) {
                // Assign to A if it has higher tip or B has reached its limit
                totalTip += order.tipA;
                countA++;
            } else {
                // Otherwise, assign to B
                totalTip += order.tipB;
                countB++;
            }
        }

        return totalTip;
    }
}

class Order {
    int index;
    int tipA;
    int tipB;
    int diff;

    Order(int index, int tipA, int tipB, int diff) {
        this.index = index;
        this.tipA = tipA;
        this.tipB = tipB;
        this.diff = diff;
    }
}