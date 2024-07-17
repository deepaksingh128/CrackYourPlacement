class Solution {
    // t.c. => O(8*m*n + m*n)  , s.c.=> O(m*n)
    public int helper(int[][] board, int i, int j) {
        int noOfOneAsNeighbours = 0;
        // up
        if (i-1 >= 0) {
            if (board[i-1][j] == 1) {
                noOfOneAsNeighbours++;
            }
        }
        // up-left
        if ((i-1) >=0 && (j-1) >= 0) {
            if (board[i-1][j-1] == 1) {
                noOfOneAsNeighbours++;
            }
        }
        // up-right
        if ((i-1) >= 0 && (j+1) < board[0].length) {
            if (board[i-1][j+1] == 1) {
                noOfOneAsNeighbours++;
            } 
        }
        // left 
        if ((j-1) >= 0) {
            if (board[i][j-1] == 1) {
                noOfOneAsNeighbours++;
            } 
        }
        // right
        if ((j+1) < board[0].length) {
            if (board[i][j+1] == 1) {
                noOfOneAsNeighbours++;
            } 
        }
        // left-down
        if ((i+1) < board.length && (j-1) >= 0) {
            if (board[i+1][j-1] == 1) {
                noOfOneAsNeighbours++;
            } 
        }
        // right-down
        if ((i+1) < board.length && (j+1) < board[0].length) {
            if (board[i+1][j+1] == 1) {
                noOfOneAsNeighbours++;
            } 
        }
        // down
        if ((i+1) < board.length) {
            if (board[i+1][j] == 1) {
                noOfOneAsNeighbours++;
            } 
        }

        return noOfOneAsNeighbours;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] temp = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int noOfOneAsNeighbours = helper(board, i, j);

                if (board[i][j] == 0) {
                    if (noOfOneAsNeighbours == 3) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = 0;
                    }
                } else {
                    if (noOfOneAsNeighbours == 2 || noOfOneAsNeighbours == 3) {
                        temp[i][j] = board[i][j];
                    } else {
                        temp[i][j] = 0;
                    }
                }
            }
        }
        // copy temp to original
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
}
