class Solution {
    // Code 2: - more readable
    int ansCount = 0;
    int totalValidSquares = 0;


    public boolean isValid (int i, int j, int[][] grid, boolean[][] visited) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && (grid[i][j] == 0 || grid[i][j] == 2) && visited[i][j] == false;
    } 

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startRow = 0, startCol = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    totalValidSquares++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        visited[startRow][startCol] = true;

        helper (grid, visited, startRow, startCol, 1);
        return ansCount;
    }

    public void helper (int[][] grid, boolean[][] visited, int i, int j, int count) {
        if (grid[i][j] == 2 && count == totalValidSquares + 2) {
            ansCount ++;
            return;
        }
        
        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Explore all 4 possible directions
        for (int dir = 0; dir < 4; dir++) {
            int newX = i + dx[dir];
            int newY = j + dy[dir];

            if (isValid(newX, newY, grid, visited)) {
                visited[newX][newY] = true;
                helper(grid, visited, newX, newY, count + 1);
                visited[newX][newY] = false; // Backtrack
            }
        }
    }
}
