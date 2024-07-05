class Solution {
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        if (root == null) {
            return 0;
        }
        
        // Set to store the unique horizontal distances
        HashSet<Integer> horizontalDistances = new HashSet<>();
        
        // Queue to store pairs of tree nodes and their horizontal distances
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node currentNode = current.node;
            int currentDistance = current.distance;
            
            // Add the current horizontal distance to the set
            horizontalDistances.add(currentDistance);
            
            // If there is a left child, add it to the queue with distance - 1
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, currentDistance - 1));
            }
            
            // If there is a right child, add it to the queue with distance + 1
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, currentDistance + 1));
            }
        }
        
        // The size of the set is the vertical width of the binary tree
        return horizontalDistances.size();
    }
    
    // Helper class to store a pair of node and its horizontal distance
    class Pair {
        Node node;
        int distance;
        Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}