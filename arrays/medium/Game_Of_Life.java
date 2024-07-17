class Solution {
    // t.c. => O(8*m*n + m*n)  , s.c.=> O(m*n)
    // code 2 :- slightly better code readability
    // we can also modify the same board with temporary state as 2 and -1 and hence do not require extra spaceat all
     
    public int helper(int[][] board, int row, int col) {
        // Count live neighbors, initializing at -board[row][col] to offset self-counting if alive
        int liveNeighbors = -board[row][col];
        for (int i = row - 1; i <= row + 1; ++i) {
            for (int j = col - 1; j <= col + 1; ++j) {
                // Check if neighbor is within bounds and alive
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] > 0) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
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


// Code :- 1

// class Solution {
//     // t.c. => O(8*m*n + m*n)  , s.c.=> O(m*n)
//     public int helper(int[][] board, int i, int j) {
//         int noOfOneAsNeighbours = 0;
//         // up
//         if (i-1 >= 0) {
//             if (board[i-1][j] == 1) {
//                 noOfOneAsNeighbours++;
//             }
//         }
//         // up-left
//         if ((i-1) >=0 && (j-1) >= 0) {
//             if (board[i-1][j-1] == 1) {
//                 noOfOneAsNeighbours++;
//             }
//         }
//         // up-right
//         if ((i-1) >= 0 && (j+1) < board[0].length) {
//             if (board[i-1][j+1] == 1) {
//                 noOfOneAsNeighbours++;
//             } 
//         }
//         // left 
//         if ((j-1) >= 0) {
//             if (board[i][j-1] == 1) {
//                 noOfOneAsNeighbours++;
//             } 
//         }
//         // right
//         if ((j+1) < board[0].length) {
//             if (board[i][j+1] == 1) {
//                 noOfOneAsNeighbours++;
//             } 
//         }
//         // left-down
//         if ((i+1) < board.length && (j-1) >= 0) {
//             if (board[i+1][j-1] == 1) {
//                 noOfOneAsNeighbours++;
//             } 
//         }
//         // right-down
//         if ((i+1) < board.length && (j+1) < board[0].length) {
//             if (board[i+1][j+1] == 1) {
//                 noOfOneAsNeighbours++;
//             } 
//         }
//         // down
//         if ((i+1) < board.length) {
//             if (board[i+1][j] == 1) {
//                 noOfOneAsNeighbours++;
//             } 
//         }

//         return noOfOneAsNeighbours;
//     }

//     public void gameOfLife(int[][] board) {
//         int m = board.length;
//         int n = board[0].length;

//         int[][] temp = new int[m][n];

//         for (int i=0; i<m; i++) {
//             for (int j=0; j<n; j++) {
//                 int noOfOneAsNeighbours = helper(board, i, j);

//                 if (board[i][j] == 0) {
//                     if (noOfOneAsNeighbours == 3) {
//                         temp[i][j] = 1;
//                     } else {
//                         temp[i][j] = 0;
//                     }
//                 } else {
//                     if (noOfOneAsNeighbours == 2 || noOfOneAsNeighbours == 3) {
//                         temp[i][j] = board[i][j];
//                     } else {
//                         temp[i][j] = 0;
//                     }
//                 }
//             }
//         }
//         // copy temp to original
//         for (int i=0; i<m; i++) {
//             for (int j=0; j<n; j++) {
//                 board[i][j] = temp[i][j];
//             }
//         }
//     }
// }
