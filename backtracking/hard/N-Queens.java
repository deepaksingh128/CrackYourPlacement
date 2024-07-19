class Solution {
    List<List<String>> res = new ArrayList<>();

    public boolean isValid (int row, int col, char[][] mat) {
        int i = row; 
        int j = col;
        // left up diagonal
        while (i >= 0 && j >= 0) {
            if (mat[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        // right up diagonal
        while (i >= 0 && j < mat.length) {
            if (mat[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        i = row;
        j = col;
        // column up
        while (i >= 0) {
            if (mat[i][j] == 'Q') {
                return false;
            }
            i--;
        }

        return true;
    }

    public void helper (char[][] mat, int row) {

        if (row == mat.length) {
            List<String> rowList = new ArrayList<>();
            String str = "";
            for (int i = 0; i < mat.length; i ++) {
                for (int j = 0; j < mat[0].length; j ++) {
                   str += mat[i][j];
                }
                rowList.add(str);
                str = "";
            }
            res.add(new ArrayList<>(rowList));
            return;
        }

        for (int j = 0; j < mat[0].length; j ++) {

            if (isValid(row, j, mat)) {

                mat[row][j] = 'Q';
                helper (mat, row + 1);
                mat[row][j] = '.';            // backtrack
            }
        }
        return;                          // when not valid for all columns in this row
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                mat[i][j] = '.';
            }
        }
        int row = 0;
        helper (mat, row);
        return res;
    }
}
