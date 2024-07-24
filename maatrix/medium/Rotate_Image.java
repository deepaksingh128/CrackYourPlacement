class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // first convert the matrix to its transpose

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j >= i) {
                    // swap
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // now exchange the columns
        int startCol = 0;
        int endCol = n - 1;

        while (startCol < endCol) {
            for (int i=0; i<n; i++) {
                int temp = matrix[i][startCol];
                matrix[i][startCol]  = matrix[i][endCol];
                matrix[i][endCol] = temp;
            }
            startCol ++;
            endCol --;
        }
    }
}
