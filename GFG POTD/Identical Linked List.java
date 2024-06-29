/*
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}*/

class Solution {
    // Function to check whether two linked lists are identical or not.
    public boolean areIdentical(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        
        // Traverse both lists
        while (current1 != null && current2 != null) {
            // If data is not the same, return false
            if (current1.data != current2.data) {
                return false;
            }
            // Move to the next nodes
            current1 = current1.next;
            current2 = current2.next;
        }
        
        // If one of the lists has more elements, return false
        if (current1 != null || current2 != null) {
            return false;
        }
        
        // If we reach here, both lists are identical
        return true;
    }
}
