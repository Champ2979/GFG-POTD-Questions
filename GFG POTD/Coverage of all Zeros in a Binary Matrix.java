class Solution {
    public int findCoverage(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalCoverage = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    if (i > 0 && matrix[i - 1][j] == 1) { // up
                        totalCoverage++;
                    }
                    if (i < rows - 1 && matrix[i + 1][j] == 1) { // down
                        totalCoverage++;
                    }
                    if (j > 0 && matrix[i][j - 1] == 1) { // left
                        totalCoverage++;
                    }
                    if (j < cols - 1 && matrix[i][j + 1] == 1) { // right
                        totalCoverage++;
                    }
                }
            }
        }
        return totalCoverage;
    }
}
