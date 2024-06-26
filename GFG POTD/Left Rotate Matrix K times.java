class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Reduce k to within the bounds of the number of columns
        k = k % cols;
        
        // Create a new matrix to store the result
        int[][] rotatedMat = new int[rows][cols];
        
        // Rotate each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate the new position of the element
                int newIndex = (j - k + cols) % cols;
                rotatedMat[i][newIndex] = mat[i][j];
            }
        }
        
        return rotatedMat;
    }
}