class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        int count = 0;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (count < m * n) {

            // top row
            for (int i=startCol; i <= endCol && count < m * n; i++) {
                list.add(matrix[startRow][i]);
                count ++;
            }
            startRow ++;

            // right col
            for (int i=startRow; i<=endRow && count < m * n; i++) {
                list.add(matrix[i][endCol]);
                count ++;
            }
            endCol --;

            // bottom row
            for (int i=endCol; i>= startCol && count < m * n; i--) {
                list.add(matrix[endRow][i]);
                count ++;
            }
            endRow --;

            // left col
            for (int i=endRow; i>= startRow && count < m * n; i--) {
                list.add(matrix[i][startCol]);
                count ++;
            }
            startCol ++;
        }

        return list;
    }
}
