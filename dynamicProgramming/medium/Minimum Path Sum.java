class Solution {
    // Approach 1 :- Recursion + Memoization

    private boolean isSafe (int[][] grid, int i ,int j) {
       return i>=0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    private int solve (int[][] grid, int i, int j, int[][] dp) {
        if (i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
        if (isSafe(grid, i, j + 1)) {
            right = solve (grid, i, j + 1, dp);
        }
        if (isSafe(grid, i + 1, j)) {
            down = solve (grid, i + 1, j, dp);
        }

        dp[i][j] = grid[i][j] + Math.min(right, down);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve (grid, 0, 0, dp);
    }
}
