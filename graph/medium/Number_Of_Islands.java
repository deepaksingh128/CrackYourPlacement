class Solution {
    // Approach 1 :- DFS
    // Other Approaches :- BFS

    int[] row = {0, 0, -1, 1};
    int[] col = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i=0; i<grid.length; i++) {

            for (int j=0; j<grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs (grid, i, j);
                    count ++;
                }

            }

        }
        return count;
    }

    public boolean isValid (char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public void dfs (char[][] grid, int i, int j) {

        if (!isValid (grid, i, j) || grid[i][j] == '0' || grid[i][j] == '$') {
            return;
        }

        grid[i][j] = '$';

        for (int k=0; k<4; k++) {
            int newX = i + row[k];
            int newY = j + col[k];

            dfs (grid, newX, newY);
        }
    }
}
