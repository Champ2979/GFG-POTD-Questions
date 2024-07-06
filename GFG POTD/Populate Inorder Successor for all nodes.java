class Solution {
    // Function to populate next pointer for all nodes
    public void populateNext(Node root) {
        // Initialize the previous node as null
        Node prev = null;
        // Start inorder traversal from root
        inorderTraversal(root, prev);
    }

    // Helper function for inorder traversal
    private Node inorderTraversal(Node node, Node prev) {
        if (node == null) {
            return prev;
        }

        // Traverse the left subtree
        prev = inorderTraversal(node.left, prev);

        // Set the next pointer of the previous node to the current node
        if (prev != null) {
            prev.next = node;
        }

        // Update the previous node to the current node
        prev = node;

        // Traverse the right subtree
        return inorderTraversal(node.right, prev);
    }
}