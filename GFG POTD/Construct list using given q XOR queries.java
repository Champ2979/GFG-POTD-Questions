import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        // Initialize the list with a single element 0
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        // This will store the cumulative XOR to be applied later
        int cumulativeXOR = 0;

        // Process each query
        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 0) {
                // Insert operation
                list.add(x ^ cumulativeXOR);
            } else if (type == 1) {
                // XOR operation
                cumulativeXOR ^= x;
            }
        }

        // Apply the cumulative XOR to each element in the list
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) ^ cumulativeXOR);
        }

        // Sort the final list
        Collections.sort(list);
        return list;
    }
}
