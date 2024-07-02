class Solution {
    public boolean compute(Node root) {
        if (root == null) return true;
        
        StringBuilder combinedString = new StringBuilder();
        
        // Traverse the linked list and combine all strings
        Node current = root;
        while (current != null) {
            combinedString.append(current.data);
            current = current.next;
        }
        
        // Check if the combined string is a palindrome
        int left = 0;
        int right = combinedString.length() - 1;
        
        while (left < right) {
            if (combinedString.charAt(left) != combinedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}