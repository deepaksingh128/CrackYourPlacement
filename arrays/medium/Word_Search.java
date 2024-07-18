class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] taken = new boolean[m][n];
        
        // Try to find the word starting from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if the first character matches
                if (board[i][j] == word.charAt(0) && helper(board, word, taken, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    // Helper function to check if the cell is valid
    public boolean isValid(int i, int j, boolean[][] taken, char[][] board, String word, int idx) {
        int wordLen = word.length();
        int m = board.length;
        int n = board[0].length;
        
        // Check bounds, if the cell is not visited and if it matches the current word character
        return idx < wordLen && i >= 0 && i < m && j >= 0 && j < n && !taken[i][j] && board[i][j] == word.charAt(idx);
    }

    // DFS 
    public boolean helper(char[][] board, String word, boolean[][] taken, int idx, int i, int j) {
        // If the entire word is found
        if (idx == word.length()) {
            return true;
        }

        // Check if the current cell is valid
        if (!isValid(i, j, taken, board, word, idx)) {
            return false;
        }

        // Mark the cell as taken
        taken[i][j] = true;

        // Explore all four possible directions
        if (helper(board, word, taken, idx + 1, i - 1, j) || // up
            helper(board, word, taken, idx + 1, i + 1, j) || // down
            helper(board, word, taken, idx + 1, i, j - 1) || // left
            helper(board, word, taken, idx + 1, i, j + 1)) { // right
            return true;
        }

        // Backtrack: unmark the cell as taken
        taken[i][j] = false;
        return false;
    }
}
