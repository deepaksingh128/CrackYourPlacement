class Solution {
  // t.c.=> O(m*n)   , s.c.=> O(1)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        // if first row contains zero
        for (int i=0; i<m; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        // if first col contains zero
        for (int i=0; i<n; i++) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if first row originally contains zero
        if (firstRow) {
            for (int i=0; i<m; i++) {
                matrix[0][i] = 0;
            }
        }

        // if first col originally contains zero
        if (firstCol) {
            for (int i=0; i<n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
