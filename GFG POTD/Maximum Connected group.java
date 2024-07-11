class Solution {
    private static int[] dRow = {-1, 1, 0, 0}; // direction vectors for rows
    private static int[] dCol = {0, 0, -1, 1}; // direction vectors for columns
    
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        
        int[][] component = new int[n][n];
        Map<Integer, Integer> componentSize = new HashMap<>();
        int componentId = 2; // starting from 2 to avoid conflict with 0 and 1 in grid
        
        // Find all components of 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && component[i][j] == 0) {
                    int size = dfs(grid, component, i, j, componentId);
                    componentSize.put(componentId, size);
                    componentId++;
                }
            }
        }
        
        int maxSize = componentSize.values().stream().max(Integer::compare).orElse(0);
        
        // Check for all 0s and calculate potential max size by converting 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborComponents = new HashSet<>();
                    int newSize = 1; // the cell itself being converted to 1
                    
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dRow[d];
                        int nj = j + dCol[d];
                        if (isInBounds(n, ni, nj) && grid[ni][nj] == 1) {
                            int neighborComponent = component[ni][nj];
                            if (!neighborComponents.contains(neighborComponent)) {
                                neighborComponents.add(neighborComponent);
                                newSize += componentSize.get(neighborComponent);
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }
        
        return maxSize;
    }
    
    private int dfs(int[][] grid, int[][] component, int row, int col, int componentId) {
        int n = grid.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        component[row][col] = componentId;
        int size = 0;
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];
            size++;
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dRow[d];
                int nc = c + dCol[d];
                if (isInBounds(n, nr, nc) && grid[nr][nc] == 1 && component[nr][nc] == 0) {
                    component[nr][nc] = componentId;
                    stack.push(new int[]{nr, nc});
                }
            }
        }
        
        return size;
    }
    
    private boolean isInBounds(int n, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}