class Solution {
    // Function to convert a linked list representation of complete binary tree to binary tree
    public Tree convert(Node head, Tree node) {
        if (head == null)
            return null;
        
        Queue<Tree> queue = new LinkedList<>();
        
        // Create root node
        Tree root = new Tree(head.data);
        queue.offer(root);
        
        Node current = head.next;
        
        while (current != null) {
            Tree parent = queue.poll();
            
            // Create left child
            if (current != null) {
                Tree leftChild = new Tree(current.data);
                parent.left = leftChild;
                queue.offer(leftChild);
                current = current.next;
            }
            
            // Create right child
            if (current != null) {
                Tree rightChild = new Tree(current.data);
                parent.right = rightChild;
                queue.offer(rightChild);
                current = current.next;
            }
        }
        
        return root;
    }
    
    // Function to print level order traversal of binary tree
    public void printLevelOrder(Tree root) {
        if (root == null)
            return;
        
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                Tree current = queue.poll();
                System.out.print(current.data + " ");
                
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        System.out.println();
    }
}